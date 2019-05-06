package org.word.puzzle.task3

import org.scalatest.{ Matchers, WordSpec }

class WordListTest extends WordSpec with Matchers {

  "WordListTest" should {

    "getAnagrams2" in {
      val wordList = List("aabcd", "dcbaa", "dbcaa", "ab", "de", "rf")

      val actual = WordList.getAnagrams(wordList)

      val expected = Map(
        "aabcd" -> Set("aabcd", "dcbaa", "dbcaa"),
        "ab" -> Set("ab"),
        "de" -> Set("de"),
        "fr" -> Set("rf")
      )
      actual shouldBe expected
    }
  }
}
