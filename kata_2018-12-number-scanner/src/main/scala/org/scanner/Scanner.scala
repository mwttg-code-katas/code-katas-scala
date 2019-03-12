package org.scanner

import scala.io.Source
import scala.util.{ Failure, Success, Try }

class Scanner {
  def read(filename: String): Option[String] = {
    val lines = readFile(filename)
    lines.map(content => constructAllNumberString(content)).map(item => translate(item))
  }

  def readFile(filename: String): Option[Seq[String]] = {
    val result = Try(Source.fromResource(filename).getLines().toSeq)
    result match {
      case Success(value) => Option(value)
      case Failure(exception) =>
        println(s"Unable to find/open the file: $exception")
        Option.empty
    }
  }

  def constructAllNumberString(lines: Seq[String]): Seq[String] = {
    val size = numbersInFile(lines.head)
    (0 until size).map(position => constructNumberString(lines, position))
  }

  def numbersInFile(line: String): Int = line.length / 3

  def constructNumberString(lines: Seq[String], position: Int): String = {
    val parts = lines.map(line => line.substring(position * 3, position * 3 + 3))
    parts.mkString
  }

  def translate(numberStrings: Seq[String]): String =
    numberStrings.map {
      case "     |  |" => "1"
      case " _  _||_ " => "2"
      case " _  _| _|" => "3"
      case "   |_|  |" => "4"
      case " _ |_  _|" => "5"
      case " _ |_ |_|" => "6"
      case " _   |  |" => "7"
      case " _ |_||_|" => "8"
      case " _ |_| _|" => "9"
    }.mkString
}

object Scanner {
  def apply(): Scanner = new Scanner()
}
