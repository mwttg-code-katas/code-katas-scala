package org.i.before.e

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object Utilities {

  def readFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().map(_.toLowerCase).toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }
}
