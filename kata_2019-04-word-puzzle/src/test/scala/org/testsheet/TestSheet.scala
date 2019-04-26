package org.testsheet

import org.scalatest.{ Matchers, WordSpec }

class TestSheet extends WordSpec with Matchers {
  "Palindrome" should {
    "check a palindrome" in {
      val input  = "otto"
      val actual = checkPalindrome(input)
      actual shouldBe true
    }
    "check a non palindrome" in {
      val input  = "palindrome"
      val actual = checkPalindrome(input)
      actual shouldBe false
    }
  }

  "stuff" should {
    "order" in {
      val str = "strRefF"
      val ord = str.sorted
      println(ord)

      val s1 = "str"
      val s2 = "rts"
      println(s1.hashCode)
      println(s2.hashCode)
    }
  }

  "ShuffleWords" should {
    "check a shuffle word" in {
      val word1  = "Leben"
      val word2  = "Nebel"
      val actual = checkAnagram(word1, word2)
      actual shouldBe true
    }
  }

  def checkPalindrome(input: String): Boolean = {
    val splitpoint = input.length / 2
    val parts      = input.splitAt(splitpoint)
    parts._1.equalsIgnoreCase(parts._2.reverse)
  }

  def checkAnagram(word1: String, word2: String): Boolean = {
    val lettersInWord1 = word1.toLowerCase.groupBy(identity).mapValues(x => x.length)
    val lettersInWord2 = word2.toLowerCase.groupBy(identity).mapValues(x => x.length)
    lettersInWord1 == lettersInWord2
  }

  // -------------------------------------------
  // Leben <-> Nebel
  def checkAnagramBad(input: String, shuffleWord: String): Boolean = {
    var word1 = input.toLowerCase().toList
    var word2 = shuffleWord.toLowerCase.toList

    for (index <- word1.indices) {
      val c = word1.head
      if (word2.contains(c)) {
        word1 = word1.drop(0)
        word2 = word2.drop(word2.indexOf(c))
      }
    }
    if (word1.isEmpty && word2.isEmpty) {
      true
    } else {
      false
    }
  }
}
