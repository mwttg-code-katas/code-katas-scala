package org.four.is.magic

import org.scalatest.{Matchers, WordSpec}

class RecombineThreeDigitWordGroupsTest extends WordSpec with Matchers {

  "RecombineThreeDigitWordGroups" should {
    "add no scale for List('xxx')" in {
      val input = List("xxx")
      val actual = RecombineThreeDigitWordGroups.combine(input)
      actual shouldBe "xxx"
    }

    "add 'thousand' scale for List('xxx', 'xxx')" in {
      val input = List("xxx", "xxx")
      val actual = RecombineThreeDigitWordGroups.combine(input)
      actual shouldBe "xxx thousand xxx"
    }

    "add 'thousand' scale for List('', 'xxx')" in {
      val input = List("", "xxx")
      val actual = RecombineThreeDigitWordGroups.combine(input)
      actual shouldBe "xxx thousand"
    }
  }

  "add 'thousand' and million scale for List('xxx', 'xxx', 'xxx')" in {
    val input = List("xxx", "xxx", "xxx")
    val actual = RecombineThreeDigitWordGroups.combine(input)
    actual shouldBe "xxx million xxx thousand xxx"
  }

  "add 'thousand' and 'million' scale for List('', 'xxx', 'xxx')" in {
    val input = List("", "xxx", "xxx")
    val actual = RecombineThreeDigitWordGroups.combine(input)
    actual shouldBe "xxx million xxx thousand"
  }

  "add 'million' scale for List('', '', 'xxx')" in {
    val input = List("", "", "xxx")
    val actual = RecombineThreeDigitWordGroups.combine(input)
    actual shouldBe "xxx million"
  }
}

