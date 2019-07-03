package org.sudoku2

import org.sudoku2.helper.StringHelper.IsNumberHelper

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object Loader {
  private val Space = " "
  private val Point = "."

  def loadSudoku(filename: String): List[Field] = {
    val lines = read(filename)
    require(
      lines.size == 9,
      "Invalid file content (not exactly 9 lines)"
    )
    lines.flatMap(line => {
      line
        .split(Space)
        .toList
        .map {
          case word: String if word.isNumber => Field(Some(word.toInt), Set.empty)
          case point: String if point == Point => Field(None, Set.empty)
          case _ => throw new IllegalArgumentException("Invalid file content (illegal character).")
        }
    })
  }

  private def read(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }
}
