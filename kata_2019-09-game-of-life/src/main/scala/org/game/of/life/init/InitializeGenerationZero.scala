package org.game.of.life.init

object InitializeGenerationZero {
  def init(lines: List[String], boardSize: BoardSize): Set[Cell] =
    GetLivingCells.get(lines, boardSize)
}
