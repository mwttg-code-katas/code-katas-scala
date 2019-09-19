package org.game.of.life.generation

import org.game.of.life.init.Cell

object ExecuteRules {
  private[generation] def exec(currentCell: Cell, neighbours: Set[Cell], livingCells: Set[Cell]) = {
    val intersection = neighbours.intersect(livingCells)
    intersection.size match {
      case x if x < 2 => None
      case x if x > 3 => None
      case x if !livingCells.contains(currentCell) && x == 3 => Some(currentCell)
      case x if livingCells.contains(currentCell) && (x == 2 || x == 3) => Some(currentCell)
      case _ => None
    }
  }
}
