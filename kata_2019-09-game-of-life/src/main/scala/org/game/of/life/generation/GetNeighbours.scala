package org.game.of.life.generation

import org.game.of.life.init.Cell

object GetNeighbours {
  private[generation] def get(currentCell: Cell) = {
    val x = currentCell.x
    val y = currentCell.y
    Set(
      Cell(x - 1, y - 1),
      Cell(x, y - 1),
      Cell(x + 1, y - 1),
      Cell(x - 1, y),
      Cell(x + 1, y),
      Cell(x - 1, y + 1),
      Cell(x, y + 1),
      Cell(x + 1, y + 1)
    )
  }
}
