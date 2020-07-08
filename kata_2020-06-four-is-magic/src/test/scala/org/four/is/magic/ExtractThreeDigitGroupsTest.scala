package org.four.is.magic

import org.scalatest.{ Matchers, WordSpec }

class ExtractThreeDigitGroupsTest extends WordSpec with Matchers {

  "ExtractThreeDigitGroups" should {
    "extract List(789, 456, 123) from number = 123456789" in {
      val actual = ExtractThreeDigitGroups.from(123456789L)
      actual should contain theSameElementsInOrderAs
      List(
        789,
        456,
        123
      )
    }

    "extract List(21) from number = 21" in {
      val actual = ExtractThreeDigitGroups.from(21L)
      actual should contain theSameElementsInOrderAs
      List(
        21
      )
    }

    "extract List(890, 567, 234, 1) from number = 123456789" in {
      val actual = ExtractThreeDigitGroups.from(1234567890L)
      actual should contain theSameElementsInOrderAs
        List(
          890,
          567,
          234,
          1
        )
    }
  }
}
