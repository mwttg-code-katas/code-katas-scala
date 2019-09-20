package org.game.of.life.process

import scala.io.Source
import scala.util.{ Failure, Success, Try }

final case class BoardSize(width: Int, height: Int)

object Utils {
  def readFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }

  def getBoardSize(lines: List[String]): BoardSize = {
    val height = lines.size
    val width  = lines.head.length
    BoardSize(width, height)
  }
}
