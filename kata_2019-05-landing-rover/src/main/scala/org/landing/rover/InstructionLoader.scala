package org.landing.rover

object InstructionLoader {
  def load(filename: String): List[Instruction] = {
    val lines = FileReader.read(filename)
    createInstructions(lines)
  }

  private val createInstructions: List[String] => List[Instruction] = lines => lines.map(line => transform(line))

  private val transform: String => Instruction = {
    case "MF" => MoveForward
    case "MB" => MoveBackwards
    case "TL" => TurnLeft
    case "TR" => TurnRight
    case _ => NoOperation
  }
}
