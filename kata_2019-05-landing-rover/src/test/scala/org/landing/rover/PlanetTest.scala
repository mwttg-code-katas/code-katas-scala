package org.landing.rover

import org.scalatest.{ Matchers, WordSpec }

class PlanetTest extends WordSpec with Matchers {
  "Planet" should {
    "be able to create from a text file" in {
      val filename = "planet-2x2.txt"
      val actual   = Planet(filename)

      actual.getSurface(Position(0, 0)) shouldBe Clearance
      actual.getSurface(Position(1, 0)) shouldBe Obstacle
      actual.getSurface(Position(0, 1)) shouldBe Unknown
      actual.getSurface(Position(1, 1)) shouldBe Clearance
    }
    "throw an exception if planet has no square input file" in {
      val filename = "no-square-planet.txt"
      an[IllegalArgumentException] should be thrownBy Planet(filename)
    }
    "throw an exception if filename does not exists" in {
      val filename = "filename-does-not-exist.txt"
      an[IllegalArgumentException] should be thrownBy Planet(filename)
    }
    "return correct maxX - start counting from 0" in {
      val filename = "planet-3x3.txt"
      val planet   = Planet(filename)
      val actual   = planet.maxX
      actual shouldBe 2
    }
    "return correct maxY - start counting from 0" in {
      val filename = "planet-3x3.txt"
      val planet   = Planet(filename)
      val actual   = planet.maxY
      actual shouldBe 2
    }
  }
}
