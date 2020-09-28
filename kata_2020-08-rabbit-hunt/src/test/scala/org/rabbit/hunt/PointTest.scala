package org.rabbit.hunt

import org.scalatest.{Matchers, WordSpec}

import scala.util.Success

class PointTest extends WordSpec with Matchers {

  "Point" should {
    "isPointOn line example 1" in {
      val line = Line(
        Point(1, 1),
        Point(5, 5)
      )
      val point  = Point(3, 3)
      val actual = Point.isPointOnLine(line, point)
      actual shouldBe true
    }
    "isPointOn line example 2 (vertical line)" in {
      val line = Line(
        Point(1, 1),
        Point(1, 5)
      )
      val point  = Point(1, 9)
      val actual = Point.isPointOnLine(line, point)
      actual shouldBe true
    }
    "isPointOn line example 3 (horizontal line)" in {
      val line = Line(
        Point(1, 1),
        Point(5, 1)
      )
      val point  = Point(9, 1)
      val actual = Point.isPointOnLine(line, point)
      actual shouldBe true
    }
    "isPointOn line example 4 (NOT)" in {
      val line = Line(
        Point(1, 1),
        Point(5, 5)
      )
      val point  = Point(2, 3)
      val actual = Point.isPointOnLine(line, point)
      actual shouldBe false
    }
  }
}
