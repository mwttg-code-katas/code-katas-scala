package org.landing.rover

sealed trait Instruction

case object MoveForward extends Instruction

case object MoveBackwards extends Instruction

case object TurnLeft extends Instruction // left turn by 90 degrees

case object TurnRight extends Instruction // right turn by 90 degrees

case object NoOperation extends Instruction
