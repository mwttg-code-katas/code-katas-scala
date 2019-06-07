package org.landing.rover

import scala.annotation.tailrec

case class Mission(name: String) {
  def start(planet: Planet, landingRover: LandingRover, instructionFilename: String): Either[String, LandingRover] = {
    println(s"""starting Mission - "$name".""")
    val instructions = InstructionLoader.load(instructionFilename)
    // TODO check is landing possible?
    startMission(instructions, planet, landingRover)
  }

  private def startMission(instructions: Seq[Instruction], planet: Planet, landingRover: LandingRover) = {
    @tailrec
    def nextStep(instructions: Seq[Instruction], accumulator: Either[String, LandingRover]): Either[String, LandingRover] = {
      println(s"step: $accumulator")
      accumulator match {
        case Left(error) => Left(error)
        case Right(lastLandingRover) =>
          instructions match {
            case Nil => accumulator
            case step :: tail =>
              val newAccumulator = lastLandingRover.executeInstruction(
                step,
                lastLandingRover.positionWithDirection,
                planet
              )
              nextStep(tail, newAccumulator)
          }
      }
    }
    nextStep(instructions, Right(landingRover))
  }
}
