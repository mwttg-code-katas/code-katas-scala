package org.word.puzzle.task1

import org.scalatest.{ Matchers, WordSpec }

class PalindromeTest extends WordSpec with Matchers {

  "Palindrome" should {
    "#check with word that has even-numbered amount of letters" in {
      val word   = "abcddcba"
      val actual = Palindrome.check(word)
      actual shouldBe true
    }
    "#check with word that has odd-numbered amount of letters" in {
      val word   = "abcdcba"
      val actual = Palindrome.check(word)
      actual shouldBe true
    }
    "#check with word that is no palindrome" in {
      val word   = "abcdefgh"
      val actual = Palindrome.check(word)
      actual shouldBe false
    }
    "#check with empty word" in {
      val word   = ""
      val actual = Palindrome.check(word)
      actual shouldBe false
    }
  }
}
