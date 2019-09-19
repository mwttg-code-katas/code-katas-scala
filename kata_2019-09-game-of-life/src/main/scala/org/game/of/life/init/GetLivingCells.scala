package org.game.of.life.init

final case class Cell(x: Int, y: Int)

object GetLivingCells {
  private val isAlive = '*'

  private[init] def get(lines: List[String], boardSize: BoardSize) = {
    val cells =
      for (y <- 0 until boardSize.height;
           x <- 0 until boardSize.width) yield {
        val character = lines(y).charAt(x)
        if (character == isAlive) {
          Some(Cell(x, y))
        } else {
          None
        }
      }
    cells.flatten.toSet
  }
}
