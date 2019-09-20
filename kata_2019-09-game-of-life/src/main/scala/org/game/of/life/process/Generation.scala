package org.game.of.life.process

final case class Cell(x: Int, y: Int)

object Generation {
  private val IsAlive = '*'

  def zero(lines: List[String], boardSize: BoardSize): Set[Cell] = {
    val cells =
      for (y <- 0 until boardSize.height;
           x <- 0 until boardSize.width) yield {
        val character = lines(y).charAt(x)
        if (character == IsAlive) {
          Some(Cell(x, y))
        } else {
          None
        }
      }
    cells.flatten.toSet
  }

  def next(livingCells: Set[Cell], boardSize: BoardSize): Set[Cell] = {
    val nextGeneration =
      for (y <- 0 until boardSize.height;
           x <- 0 until boardSize.width) yield {
        val currentCell = Cell(x, y)
        val neighbours  = neighboursOf(currentCell)
        applyRules(currentCell, neighbours, livingCells)
      }
    nextGeneration.flatten.toSet
  }

  private def neighboursOf(currentCell: Cell) = {
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

  private def applyRules(currentCell: Cell, neighbours: Set[Cell], livingCells: Set[Cell]) = {
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
