package org.moby.dick
import org.scalatest.{ Matchers, WordSpec }

class MobyDickTest extends WordSpec with Matchers {

  "MobyDickTest" should {

    "allWords" in {
      val words = List(
        "Is  this the FIRST line? Yes.",
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
        "it's",
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

    "readFile - read a text file" in {
      val filename = "test-lines.txt"
      val actual   = Top20.readFile(filename)
      actual.get should contain theSameElementsAs List(
        "3. line",
        "1. line",
        "This is a second line. It's a nice line, because it has some funny stuff."
      )
    }
    "readFile - throw an exception for unknown filename" in {
      an[RuntimeException] should be thrownBy Top20.readFile("filename is unknown").get
    }

  }
}
