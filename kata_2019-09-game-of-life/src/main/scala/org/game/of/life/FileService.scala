package org.game.of.life

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object FileService {
  def read(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }
}
