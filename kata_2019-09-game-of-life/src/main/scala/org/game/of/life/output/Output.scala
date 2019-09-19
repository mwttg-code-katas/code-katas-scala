package org.game.of.life.output

import org.game.of.life.init.{ BoardSize, Cell }

object Output {
  private val Alive = '*'
  private val Dead  = '.'

  def printGeneration(boardSize: BoardSize, livingCells: Set[Cell]): Unit =
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
