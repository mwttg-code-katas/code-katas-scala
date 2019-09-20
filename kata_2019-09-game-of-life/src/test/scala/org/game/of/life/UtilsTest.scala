package org.game.of.life

import org.scalatest.{ Matchers, WordSpec }

class UtilsTest extends WordSpec with Matchers {
  "Utilities" should {
    "read a text file with valid filename" in {
      Utils.readFile("testfile.txt") shouldBe List("first line", "second line", "third line")
    }
    "return an empty list, when reading invalid filename" in {
      Utils.readFile("invalid-filename.txt") shouldBe List.empty[String]
    }
    "return the dimension of a board" in {
      val input = List(".....", ".....", ".....")
      Utils.getWorldSize(input) shouldBe WorldSize(5, 3)
    }
  }
}
