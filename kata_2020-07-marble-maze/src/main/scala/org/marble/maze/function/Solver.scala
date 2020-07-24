package org.marble.maze.function

object Solver {

  private final case class Accumulator(positions: Seq[Position], currentColumn: Int)

  def getStartPositions(top: Seq[Boolean]): Seq[Position] =
    top
      .foldLeft(Accumulator(Seq.empty[Position], 0)) { (accumulator, tile) =>
        {
          if (tile) {
            Accumulator(
              accumulator.positions :+ Position(accumulator.currentColumn, 0),
              accumulator.currentColumn + 1
            )
          } else {
            Accumulator(accumulator.positions, accumulator.currentColumn + 1)
          }
        }
      }
      .positions
}
