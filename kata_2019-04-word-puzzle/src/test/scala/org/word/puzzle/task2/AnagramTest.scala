package org.word.puzzle.task2

import org.scalatest.{ Matchers, WordSpec }

class AnagramTest extends WordSpec with Matchers {
  "Anagram" should {
    "#check if 'Leben' and 'Nebel' are anagrams" in {
      val actual = Anagram.check("Leben", "Nebel")
      actual shouldBe true
    }
    "#check if 'abcde' and 'zyxvw' are anagrams" in {
      val actual = Anagram.check("abcde", "zyxvw")
      actual shouldBe false
    }
  }
}
