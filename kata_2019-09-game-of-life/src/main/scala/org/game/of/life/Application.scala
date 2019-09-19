package org.game.of.life

import org.game.of.life.generation.GameOfLifeLoop
import org.game.of.life.init.{ GetBoardSize, InitializeGenerationZero }

object Application {
  val generation = 150
  val filename   = "glider-2.txt"

  def main(args: Array[String]): Unit = {
    val lines          = FileService.read(filename)
    val boardSize      = GetBoardSize.get(lines)
    val generationZero = InitializeGenerationZero.init(lines, boardSize)
    GameOfLifeLoop.loop(generation, generationZero, boardSize)
  }
}
