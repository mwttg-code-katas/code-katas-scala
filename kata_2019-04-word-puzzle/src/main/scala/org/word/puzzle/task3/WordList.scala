package org.word.puzzle.task3

import scala.io.Source
import scala.util.{ Failure, Success, Try }

object WordList {
  def getAnagrams(wordList: List[String]): Map[String, Set[String]] = {
    var result = Map.empty[String, Set[String]]
    for (word <- wordList) {
      val key = word.toLowerCase.sorted
      if (result.keySet.contains(key)) {
        val anagrams = result(key) + word
        result = result + (key -> anagrams)

      } else {
        result = result + (key -> Set(word))
      }
    }
    result
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

  // TODO using var in #getAnagrams seems not to be the 'right' functional way
  // a better approach would be nice (perhaps something with fold to extend the map?)
}
