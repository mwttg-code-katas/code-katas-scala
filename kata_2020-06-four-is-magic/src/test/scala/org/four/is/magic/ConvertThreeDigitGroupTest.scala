package org.four.is.magic

import org.scalatest.{Matchers, WordSpec}

class ConvertThreeDigitGroupTest extends WordSpec with Matchers {

  "ConvertThreeDigitGroup" should {
    "create 'one hundred twenty three' from 123" in {
      val actual = ConvertThreeDigitGroup.toWord(123)
      actual shouldBe "one hundred twenty three"
    }

    "create 'twenty one' from 21" in {
      val actual = ConvertThreeDigitGroup.toWord(21)
      actual shouldBe "twenty one"
    }

    "create 'twelve' from 12" in {
      val actual = ConvertThreeDigitGroup.toWord(12)
      actual shouldBe "twelve"
    }

    "create 'five' from 5" in {
      val actual = ConvertThreeDigitGroup.toWord(5)
      actual shouldBe "five"
    }

    "create 'nine hundred ninety nine' from 999" in {
      val actual = ConvertThreeDigitGroup.toWord(999)
      actual shouldBe "nine hundred ninety nine"
    }
  }
}
