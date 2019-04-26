package org.word.puzzle.newTry

import scala.collection.mutable
import scala.io.Source
import scala.util.{ Failure, Success, Try }

object Kata {

  def main(args: Array[String]): Unit = {
    println(palindrome("Madam"))
    println(palindrome("123321"))

    println(anagram("Listen", "Silent"))
  }

  def palindrome(word: String) = {
    val evenLetterAmount = word.length % 2 == 0
    val splitIndex = if (evenLetterAmount) {
      (word.length / 2) + 1
    } else {
      word.length / 2
    }

    val tuple = word.splitAt(splitIndex)
    // word.sp
    val first  = tuple._1.toLowerCase
    val second = tuple._2.toLowerCase

    first == second.reverse
  }

  def anagram(word1: String, word2: String) = {
    val letters1 = word1.toLowerCase.sorted
    val letters2 = word2.toLowerCase.sorted
    letters1 == letters2
  }

  def anagrams(file: String) = {
    val lines    = readFile(file).get
    var anagrams = mutable.Map.empty[String, List[String]]

    lines.map(word => {
      val letters = word.toLowerCase.sorted
      if (anagrams.keySet contains letters) {
        val list   = anagrams(letters)
        val result = list :+ word
        //   anagrams = anagrams :+ letters -> result
      }

    })

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
}
