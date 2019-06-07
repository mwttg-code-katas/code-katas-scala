package org.landing.rover

case class PositionWithDirection(position: Position, direction: Direction)

object PositionWithDirection {

  val turnLeft: PositionWithDirection => PositionWithDirection = positionWithDirection => {
    val direction = positionWithDirection.direction
    val position  = positionWithDirection.position

    direction match {
      case North => PositionWithDirection(position, West)
      case West => PositionWithDirection(position, South)
      case South => PositionWithDirection(position, East)
      case East => PositionWithDirection(position, North)
    }
  }

  val turnRight: PositionWithDirection => PositionWithDirection = positionWithDirection => {
    val direction = positionWithDirection.direction
    val position  = positionWithDirection.position

    direction match {
      case North => PositionWithDirection(position, East)
      case East => PositionWithDirection(position, South)
      case South => PositionWithDirection(position, West)
      case West => PositionWithDirection(position, North)
    }
  }

  val moveForward: PositionWithDirection => PositionWithDirection = positionWithDirection => {
    val direction = positionWithDirection.direction
    val position  = positionWithDirection.position

    direction match {
      case North => PositionWithDirection(Position(position.x, position.y - 1), North)
      case East => PositionWithDirection(Position(position.x + 1, position.y), East)
      case South => PositionWithDirection(Position(position.x, position.y + 1), South)
      case West => PositionWithDirection(Position(position.x - 1, position.y), West)
    }
  }

  val moveBackwards: PositionWithDirection => PositionWithDirection = positionWithDirection => {
    val direction = positionWithDirection.direction
    val position  = positionWithDirection.position

    direction match {
      case North => PositionWithDirection(Position(position.x, position.y + 1), North)
      case East => PositionWithDirection(Position(position.x - 1, position.y), East)
      case South => PositionWithDirection(Position(position.x, position.y - 1), South)
      case West => PositionWithDirection(Position(position.x + 1, position.y), West)
    }
  }

  val normalizePositionOnSphere: (PositionWithDirection, Planet) => PositionWithDirection = (positionWithDirection, planet) => {
    val maxX      = planet.maxX
    val maxY      = planet.maxY
    val direction = positionWithDirection.direction
    val position  = positionWithDirection.position

    val Position(x, y) = position

    val newX = x match {
      case xn if xn > maxX => 0
      case xn if xn < 0 => maxX
      case xn => xn
    }
    val newY = y match {
      case yn if yn > maxY => 0
      case yn if yn < 0 => maxY
      case yn => yn
    }

    val newPosition = Position(newX, newY)
    PositionWithDirection(newPosition, direction)
  }
}
