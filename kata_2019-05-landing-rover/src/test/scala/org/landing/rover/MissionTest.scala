package org.landing.rover

import org.scalatest.{ Matchers, WordSpec }

class MissionTest extends WordSpec with Matchers {
  "Mission" should {
    "create for a valid mission a valid result" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(0, 1), East)
      val landingRover          = LandingRover(positionWithDirection)

      val subject = Mission("Test - Mission 1")
      val actual = subject.start(
        planet,
        landingRover,
        "test-mission-instructions.txt"
      )
      actual shouldBe Right(LandingRover(PositionWithDirection(Position(2, 1), East)))
    }
    "create for a failing mission a valid result" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(0, 1), South)
      val landingRover          = LandingRover(positionWithDirection)

      val subject = Mission("Test - Mission 2")
      val actual = subject.start(
        planet,
        landingRover,
        "test-mission-instructions.txt"
      )
      actual shouldBe Left(s"""This instruction can NOT be executed.
                               |Obstacle at x=0 y=2
                               |My position is still x=0 y=1""".stripMargin)
    }
    "create for a longer valid mission a valid result" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(0, 1), East)
      val landingRover          = LandingRover(positionWithDirection)

      val subject = Mission("Test - Mission 3")
      val actual = subject.start(
        planet,
        landingRover,
        "test-mission-longer-instructions.txt"
      )
      actual shouldBe Right(LandingRover(PositionWithDirection(Position(1, 2), South)))
    }
  }
}
