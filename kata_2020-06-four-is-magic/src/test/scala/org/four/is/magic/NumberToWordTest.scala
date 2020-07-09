package org.four.is.magic

import org.scalatest.{Matchers, WordSpec}

class NumberToWordTest extends WordSpec with Matchers {

  "NumberToWord" should {
    "convert 123 to 'one hundred twenty three'" in {
      val actual = NumberToWord.convert(123)
      actual shouldBe "one hundred twenty three"
    }

    "convert 1234 to 'one thousand two hundred thirty four'" in {
      val actual = NumberToWord.convert(1234)
      actual shouldBe "one thousand two hundred thirty four"
    }

    "convert 12345 to 'twelve thousand three hundred forty five'" in {
      val actual = NumberToWord.convert(12345)
      actual shouldBe "twelve thousand three hundred forty five"
    }

    "convert 123456 to 'one hundred twenty three thousand four hundred fifty six'" in {
      val actual = NumberToWord.convert(123456)
      actual shouldBe "one hundred twenty three thousand four hundred fifty six"
    }

    "convert 1234567 to 'one million two hundred thirty four thousand five hundred sixty seven'" in {
      val actual = NumberToWord.convert(1234567)
      actual shouldBe "one million two hundred thirty four thousand five hundred sixty seven"
    }

    "convert 1000001 to 'one million one'" in {
      val actual = NumberToWord.convert(1000001)
      actual shouldBe "one million one"
    }
  }

}
