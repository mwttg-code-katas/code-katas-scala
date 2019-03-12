package org.moby.dick

import org.scalatest.{ Matchers, WordSpec }

class Top20Test extends WordSpec with Matchers {

  "MobyDickTest" should {

    "sortTable" in {
      val input = Map(
        "hello" -> 3,
        "world" -> 10,
        "me" -> 5,
        "test" -> 2,
        "input" -> 6
      )
      val actual = Top20.sortTable(input)
      // not sure how to test the order, yet
    }

    "createTable" in {
      val words  = List("hello", "hello", "world", "hello")
      val actual = Top20.createTable(words)
      actual shouldBe Map("world" -> 1, "hello" -> 3)
    }

    "allWords" in {
      val words = List(
        "Is this the FIRST line? Yes.",
        "This is the SECOND line! It's a funny line, because it has some extra stuff...",
        "This is a THIRD line."
      )

      val actual = Top20.allWords(words)
      actual should contain theSameElementsAs List(
        "line",
        "third",
        "a",
        "is",
        "this",
        "stuff",
        "extra",
        "some",
        "has",
        "it",
        "because",
        "line",
        "funny",
        "a",
        "s",
        "it",
        "line",
        "second",
        "the",
        "is",
        "this",
        "yes",
        "line",
        "first",
        "the",
        "this",
        "is"
      )
    }
    "readFile - throw an exception for unknown filename" in {
      an[RuntimeException] should be thrownBy Top20.readFile("filename is unknown").get
    }

  }
}
