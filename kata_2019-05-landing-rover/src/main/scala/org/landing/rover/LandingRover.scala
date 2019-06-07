package org.landing.rover

import org.landing.rover.PositionWithDirection._

final case class LandingRover(positionWithDirection: PositionWithDirection) {

  def executeInstruction(instruction: Instruction,
                         positionWithDirection: PositionWithDirection,
                         planet: Planet): Either[String, LandingRover] = {

    val newPositionWithDirection = move(instruction, positionWithDirection, planet)

    if (planet.getSurface(newPositionWithDirection.position) == Clearance) {
      Right(LandingRover(newPositionWithDirection))
    } else {
      // TODO Think about a refactoring, instead returning a string return a MissionAbort(PositionWithDirection, Message)
      Left(
        s"""This instruction can NOT be executed.
           |Obstacle at x=${newPositionWithDirection.position.x} y=${newPositionWithDirection.position.y}
           |My position is still x=${positionWithDirection.position.x} y=${positionWithDirection.position.y}""".stripMargin
      )
    }
  }

  private def move(instruction: Instruction, positionWithDirection: PositionWithDirection, planet: Planet) = {
    val newPositionWithDirection = instruction match {
      case MoveForward => moveForward(positionWithDirection)
      case MoveBackwards => moveBackwards(positionWithDirection)
      case TurnLeft => turnLeft(positionWithDirection)
      case TurnRight => turnRight(positionWithDirection)
      case NoOperation => positionWithDirection
    }
    normalizePositionOnSphere(newPositionWithDirection, planet)
  }
}
