package org.game.of.life.init

final case class BoardSize(width: Int, height: Int)

object GetBoardSize {
  def get(lines: List[String]): BoardSize = {
    val height = lines.size
    val width  = lines.head.length
    BoardSize(width, height)
  }
}
