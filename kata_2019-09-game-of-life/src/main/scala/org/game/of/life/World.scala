package org.game.of.life

final case class Cell(x: Int, y: Int)

final case class World(livingCells: Set[Cell], generation: Int, size: WorldSize) {
  import World._

  def next(): World = {
    val nextGeneration = forEachCell(size, livingCells, nextGenerationFunc)
    World(nextGeneration, generation + 1, size)
  }
}

object World {
  private val IsAlive = '*'

  def apply(lines: List[String], worldSize: WorldSize): World = {
    val livingCells = forEachCell(worldSize, lines, linesTransformFunc)
    World(livingCells, 0, worldSize)
  }

  private def forEachCell[T](worldSize: WorldSize, input: T, f: (Int, Int, T) => Option[Cell]) = {
    val cells =
      for (y <- 0 until worldSize.height;
           x <- 0 until worldSize.width) yield {
        f(x, y, input)
      }
    cells.flatten.toSet
  }

  private def linesTransformFunc(x: Int, y: Int, items: List[String]) = {
    val character = items(y).charAt(x)
    if (character == IsAlive) {
      Some(Cell(x, y))
    } else {
      None
    }
  }

  private def nextGenerationFunc(x: Int, y: Int, livingCells: Set[Cell]) = {
    val currentCell = Cell(x, y)
    val neighbours  = neighboursOf(x, y)
    applyRules(currentCell, neighbours, livingCells)
  }

  private def neighboursOf(x: Int, y: Int) =
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
