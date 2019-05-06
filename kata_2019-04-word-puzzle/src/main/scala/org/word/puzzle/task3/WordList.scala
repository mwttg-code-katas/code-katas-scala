package org.word.puzzle.task3

import scala.io.Source
import scala.util.{Failure, Success, Try}

object WordList {
  def getAnagrams(wordList: List[String]): Map[String, Set[String]] = {
    wordList.foldLeft(Map.empty[String, Set[String]]) {
      (dict, word) => {

        val wordSorted = word.toLowerCase.sorted
        if (dict.keySet.contains(wordSorted)) {
          val newValues = dict(wordSorted) + word
          dict + (wordSorted -> newValues)
        } else {
          dict + (wordSorted -> Set(word))
        }
      }
    }
  }

  def readFile(filename: String): Option[List[String]] = {
    val result = Try(Source.fromResource(filename).getLines().toList)
    result match {
      case Success(value) => Option(value)
      case Failure(exception) =>
        println(s"Unable to find/open the file: $exception")
        Option.empty
    }
  }
}
