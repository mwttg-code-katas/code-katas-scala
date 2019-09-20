package org.game.of.life

import scala.annotation.tailrec

import org.game.of.life.process._

object Application {

  /**
    * Interesting files:
    *  - pentomino.txt    TargetGeneration = 1120
    *  - glider-2.txt     TargetGeneration = 120
    *  - symetric.txt     TargetGeneration = 55
    *
    * Best visualization on sbt (terminal):
    *   - sbt
    *   - project kata_2019-09-game-of-life
    *   - runMain org.game.of.life.Application
    *
    *
    */
  private val TargetGeneration = 120
  private val Delay            = 50
  private val Filename         = "glider-2.txt"
  private val Alive            = '*'
  private val Dead             = '.'

  def main(args: Array[String]): Unit = {
    val lines          = Utils.readFile(Filename)
    val boardSize      = Utils.getBoardSize(lines)
    val generationZero = Generation.zero(lines, boardSize)
    loop(TargetGeneration, generationZero, boardSize)
  }

  @tailrec
  private def loop(targetGeneration: Int, generation: Set[Cell], boardSize: BoardSize): Set[Cell] =
    if (targetGeneration == 0) {
      printGeneration(boardSize, generation, 0)
      generation
    } else {
      val nextGeneration = Generation.next(generation, boardSize: BoardSize)
      printGeneration(boardSize, generation, targetGeneration)
      loop(targetGeneration - 1, nextGeneration, boardSize)
    }

  private def printGeneration(boardSize: BoardSize, livingCells: Set[Cell], targetGeneration: Int): Unit = {
    println(s"\n Generations left = $targetGeneration \n")
    Thread.sleep(Delay)

    for (y <- 0 until boardSize.height;
         x <- 0 until boardSize.width) {
      val currentCell = Cell(x, y)

      if (livingCells.contains(currentCell)) {
        print(Alive)
      } else {
        print(Dead)
      }
      if (x == boardSize.width - 1) {
        print("\n")
      }
    }
  }
}
