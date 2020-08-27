package org.rabbit.hunt

import org.scalatest.{ Matchers, WordSpec }

class RabbitsTest extends WordSpec with Matchers {

  "Rabbits" should {
    "initialized from a file" in {
      val filename = "test-file.txt"
      val actual   = Rabbits.initialize(filename)

      actual shouldBe Rabbits(2, Set(Point(3, 3), Point(5, 5)))
    }
  }
}
