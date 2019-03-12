package org.scanner
import org.scalatest.{ Matchers, WordSpec }

class ScannerTest extends WordSpec with Matchers {
  "Scanner" must {
    "read the input file" should {
      "return content as Seq of lines" in {
        val filename = "input-test.txt"
        val actual   = Scanner().readFile(filename).get

        actual should contain theSameElementsInOrderAs Seq("line 1", "line 2", "line 3")
      }
      "return Option.empty if file don't exist" in {
        val filename = "this-file-does-not-edxist.txt"
        val actual   = Scanner().readFile(filename)
        actual shouldBe None
      }
    }
    "calculate how many numbers are in the file" should {
      "return correct number" in {
        val input  = "123456789"
        val actual = Scanner().numbersInFile(input)
        actual shouldBe 3
      }
    }
    "construct the one number from the input" should {
      "return correct String with single number" in {
        val input  = Seq("123", "456", "789")
        val actual = Scanner().constructNumberString(input, 0)
        actual shouldBe "123456789"
      }
      "return correct String with 2 numbers" in {
        val input  = Seq("111222", "111222", "111222")
        val actual = Scanner().constructNumberString(input, 1)
        actual shouldBe "222222222"
      }
      "return correct String with 3 numbers" in {
        val input  = Seq("111222333", "111222333", "111222333")
        val actual = Scanner().constructNumberString(input, 1)
        actual shouldBe "222222222"
      }
    }
    "construct all numbers from complete input" should {
      "return correct String from single number input" in {
        val input  = Seq("123", "456", "789")
        val actual = Scanner().constructAllNumberString(input)
        actual shouldBe Seq("123456789")
      }
      "return correct Strings for mutiple numbers" in {
        val input  = Seq("111222333", "111222333", "111222333")
        val actual = Scanner().constructAllNumberString(input)
        actual should contain theSameElementsInOrderAs Seq("111111111", "222222222", "333333333")
      }
    }
    "translate the Strings to numbers" should {
      "translate single 1" in {
        val input  = Seq("     |  |")
        val actual = Scanner().translate(input)
        actual shouldBe "1"
      }
      "translate single 2" in {
        val input  = Seq(" _  _||_ ")
        val actual = Scanner().translate(input)
        actual shouldBe "2"
      }
      "translate single 3" in {
        val input  = Seq(" _  _| _|")
        val actual = Scanner().translate(input)
        actual shouldBe "3"
      }
      "translate single 4" in {
        val input  = Seq("   |_|  |")
        val actual = Scanner().translate(input)
        actual shouldBe "4"
      }
      "translate single 5" in {
        val input  = Seq(" _ |_  _|")
        val actual = Scanner().translate(input)
        actual shouldBe "5"
      }
      "translate single 6" in {
        val input  = Seq(" _ |_ |_|")
        val actual = Scanner().translate(input)
        actual shouldBe "6"
      }
      "translate single 7" in {
        val input  = Seq(" _   |  |")
        val actual = Scanner().translate(input)
        actual shouldBe "7"
      }
      "translate single 8" in {
        val input  = Seq(" _ |_||_|")
        val actual = Scanner().translate(input)
        actual shouldBe "8"
      }
      "translate single 9" in {
        val input  = Seq(" _ |_| _|")
        val actual = Scanner().translate(input)
        actual shouldBe "9"
      }
      "translate multiple numbers" in {
        val input  = Seq(" _ |_| _|", " _ |_||_|")
        val actual = Scanner().translate(input)
        actual shouldBe "98"
      }
    }
    "transform a whole file" should {
      "return the correct result" in {
        val filename = "code.txt"
        val actual   = Scanner().read(filename)
        actual shouldBe Option("123456789")
      }
    }
  }
}
