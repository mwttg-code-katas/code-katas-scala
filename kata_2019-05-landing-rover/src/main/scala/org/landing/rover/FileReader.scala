package org.landing.rover

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object FileReader {
  val read: String => List[String] = filename => {
    val fileContent = readFile(filename)
    getLines(fileContent)
  }

  private val readFile: String => Try[List[String]] = filename => Try(Source.fromResource(filename).getLines().toList)

  private val getLines: Try[List[String]] => List[String] = {
    case Success(lines) => lines
    case Failure(ex) => throw new IllegalArgumentException(s"Filename was not found. Cause was: $ex")
  }
}
