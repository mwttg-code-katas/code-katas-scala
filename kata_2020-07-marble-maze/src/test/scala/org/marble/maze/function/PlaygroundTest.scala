package org.marble.maze.function

import org.scalatest.{ Matchers, TryValues, WordSpec }

class PlaygroundTest extends WordSpec with Matchers with TryValues {

  "Playground#from" should {
    "read a file" in {
      val actual = Playground.from("simple-maze.txt")
      actual shouldBe Seq("X X", "X X", "X X");
    }
  }

  "Playground#transform" should {
    "transform file content - example 1" in {
      val fileContent = Seq("X X", "X X", "X X")
      val actual      = Playground.transform(fileContent)
      actual should contain theSameElementsInOrderAs Seq(
        Seq(false, true, false),
        Seq(false, true, false),
        Seq(false, true, false)
      )
    }

    "transform file content - example 2" in {
      val fileContent = Seq("XXX", "  X", "X  ")
      val actual      = Playground.transform(fileContent)
      actual should contain theSameElementsInOrderAs Seq(
        Seq(false, false, false),
        Seq(true, true, false),
        Seq(false, true, true)
      )
    }

    "Playground#createFrom" should {
      "create a playground from a file" in {
        val actual = Playground.createFrom("simple-maze.txt")
        actual shouldBe Playground(
          Dimension(3, 3),
          Seq(
            Seq(false, true, false),
            Seq(false, true, false),
            Seq(false, true, false)
          )
        )
      }
    }
  }
}
