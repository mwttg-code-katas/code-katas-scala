package org.i.before.e

import scala.io.Source
import scala.util.{ Failure, Success, Try }

final case class Line(word: String, frequency: Int)

object Utilities {

  def readFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().map(_.toLowerCase).toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }

  def readFileWithFrequencies(filename: String): List[Line] = {
    Try(Source.fromResource(filename).getLines().drop(1).flatMap(line => createLine(line)).toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }
  }

  private def createLine(line: String) = {
    val parts = line.trim.split("\\s+").toList
    if (parts.size == 3) {
      Some(Line(parts(0).toLowerCase, parts(2).toInt))
    } else {
      None
    }
  }
}
