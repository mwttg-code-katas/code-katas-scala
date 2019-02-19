package org.moby.dick

import org.scalatest.{ Matchers, WordSpec }

import scala.io.Source
import scala.util.Try

class TestSheet extends WordSpec with Matchers {
  "TestSheet" should {
    "read a file line per line" in {
      val lines = readFile("test-mobydick.txt")
      println(lines.size)
    }
    "split a line (string into words" in {
      val line   = "This is my input line. It has two sentences. And some extra stuff ..."
      val actual = splitLineIntoWords(line)
      actual.foreach(println)
    }
    "add a word to map" in {
      val words  = Map("Hello" -> 2, "World" -> 2)
      val actual = addWord(words, "Hello")
      println(actual)
    }
//    "whole process" in {
//      val wordsByAmount = Map.empty[String, Int] // var :(
//      val lines = readFile("test-mobydick.txt")
//
//      val result = lines.map(line => {
//        val words = splitLineIntoWords(line)
//        words.map(word => {
//          addWord(wordsByAmount, word.toLowerCase)
//        })
//      })
//      println(result)
//    }
    "whole process" in {
      val wordsByAmount = Map.empty[String, Int] // var :(
      val lines         = readFile("test-mobydick.txt")

      var wordsByCount = Map.empty[String, Int]

      for (line <- lines) {
        val words = splitLineIntoWords(line)

        for (word <- words) {
          wordsByCount = addWord(wordsByCount, word)
        }
      }

      println(wordsByCount.values.max)

      println(wordsByCount)
    }
  }

  private def readFile(filename: String) =
    Try(Source.fromResource(filename).getLines().toList).get

  private def splitLineIntoWords(line: String) =
    // line.split("\\s+").toList
    line.split("(\\.|,|\\?|\\!|\\s+)").filterNot(word => word == "").map(word => word.toLowerCase).toList

  private def addWord(words: Map[String, Int], newWord: String) =
    if (words.keySet.contains(newWord)) {
      val count = words(newWord)
      words + (newWord -> (count + 1))
    } else {
      words + (newWord -> 1)
    }

  private def mergeMaps(first: Map[String, Int], second: Map[String, Int]) = {
 //   first.
  }
}
