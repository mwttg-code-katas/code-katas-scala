package org.game.of.life.generation

import scala.annotation.tailrec

import org.game.of.life.init.{ BoardSize, Cell }
import org.game.of.life.output.Output

object GameOfLifeLoop {
  @tailrec
  def loop(targetGeneration: Int, generation: Set[Cell], boardSize: BoardSize): Set[Cell] =
    if (targetGeneration == 0) {
      generation
    } else {
      val nextGeneration = NextGeneration.next(generation, boardSize: BoardSize)

      Output.printGeneration(boardSize, generation)
      // println(s"\u001B \n Generations left = ${targetGeneration - 1} \n")
      println(s"\n Generations left = ${targetGeneration - 1} \n")

      Thread.sleep(50)

      loop(targetGeneration - 1, nextGeneration, boardSize)
    }
}
