package org.wordchain

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object InputReader {

  def read(filename: String): Map[Int, List[String]] = {
    val lines = readFile(filename)
    wordsByLength(lines)
  }

  private def readFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }

  private def wordsByLength(lines: List[String]): Map[Int, List[String]] = {
    lines.foldLeft(Map.empty[Int, List[String]]) { (accumulator, word)  => {
      val wordLength = word.length
      if (accumulator.keySet.contains(wordLength)) {
        val words = accumulator(wordLength)
        val newList = words :+ word
        accumulator + (wordLength -> newList)
      } else {
        accumulator + (wordLength -> List(word))
      }
    }}
  }
}
