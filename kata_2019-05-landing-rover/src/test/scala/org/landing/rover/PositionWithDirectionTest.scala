package org.landing.rover

import org.landing.rover.PositionWithDirection._
import org.scalatest.{ Matchers, WordSpec }

class PositionWithDirectionTest extends WordSpec with Matchers {
  "PositionWithDirection" should {
    val position = Position(1, 1)

    "turnLeft function: North" in {
      turnLeft(PositionWithDirection(position, North)) shouldBe PositionWithDirection(position, West)
    }
    "turnLeft function: West" in {
      turnLeft(PositionWithDirection(position, West)) shouldBe PositionWithDirection(position, South)
    }
    "turnLeft function: South" in {
      turnLeft(PositionWithDirection(position, South)) shouldBe PositionWithDirection(position, East)
    }
    "turnLeft function: East" in {
      turnLeft(PositionWithDirection(position, East)) shouldBe PositionWithDirection(position, North)
    }
    "turnRight function: North" in {
      turnRight(PositionWithDirection(position, North)) shouldBe PositionWithDirection(position, East)
    }
    "turnRight function: East" in {
      turnRight(PositionWithDirection(position, East)) shouldBe PositionWithDirection(position, South)
    }
    "turnRight function: South" in {
      turnRight(PositionWithDirection(position, South)) shouldBe PositionWithDirection(position, West)
    }
    "turnRight function: West" in {
      turnRight(PositionWithDirection(position, West)) shouldBe PositionWithDirection(position, North)
    }
    "moveForward direction North function" in {
      moveForward(PositionWithDirection(position, North)) shouldBe PositionWithDirection(Position(1, 0), North)
    }
    "moveForward direction East function" in {
      moveForward(PositionWithDirection(position, East)) shouldBe PositionWithDirection(Position(2, 1), East)
    }
    "moveForward direction South function" in {
      moveForward(PositionWithDirection(position, South)) shouldBe PositionWithDirection(Position(1, 2), South)
    }
    "moveForward direction West function" in {
      moveForward(PositionWithDirection(position, West)) shouldBe PositionWithDirection(Position(0, 1), West)
    }
    "moveBackwards direction North function" in {
      moveBackwards(PositionWithDirection(position, North)) shouldBe PositionWithDirection(Position(1, 2), North)
    }
    "moveBackwards direction East function" in {
      moveBackwards(PositionWithDirection(position, East)) shouldBe PositionWithDirection(Position(0, 1), East)
    }
    "moveBackwards direction South function" in {
      moveBackwards(PositionWithDirection(position, South)) shouldBe PositionWithDirection(Position(1, 0), South)
    }
    "moveBackwards direction West function" in {
      moveBackwards(PositionWithDirection(position, West)) shouldBe PositionWithDirection(Position(2, 1), West)
    }
    "normalizePositionOnSphere over top" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(1, 0), North)
      val next                  = moveForward(positionWithDirection)
      val actual                = normalizePositionOnSphere(next, planet)
      actual shouldBe PositionWithDirection(Position(1, 2), North)
    }
    "normalizePositionOnSphere over right" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(2, 1), East)
      val next                  = moveForward(positionWithDirection)
      val actual                = normalizePositionOnSphere(next, planet)
      actual shouldBe PositionWithDirection(Position(0, 1), East)
    }
    "normalizePositionOnSphere over bottom" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(1, 2), South)
      val next                  = moveForward(positionWithDirection)
      val actual                = normalizePositionOnSphere(next, planet)
      actual shouldBe PositionWithDirection(Position(1, 0), South)
    }
    "normalizePositionOnSphere over left" in {
      val planet                = Planet("planet-3x3.txt")
      val positionWithDirection = PositionWithDirection(Position(0, 1), West)
      val next                  = moveForward(positionWithDirection)
      val actual                = normalizePositionOnSphere(next, planet)
      actual shouldBe PositionWithDirection(Position(2, 1), West)
    }
  }
}
