package org.game.of.life.generation

import org.game.of.life.init.{ BoardSize, Cell }

object NextGeneration {
  def next(livingCells: Set[Cell], boardSize: BoardSize): Set[Cell] = {
    val nextGeneration =
      for (y <- 0 until boardSize.height;
           x <- 0 until boardSize.width) yield {
        val currentCell = Cell(x, y)
        val neighbours  = GetNeighbours.get(currentCell)
        ExecuteRules.exec(currentCell, neighbours, livingCells)
      }
    nextGeneration.flatten.toSet
  }
}
