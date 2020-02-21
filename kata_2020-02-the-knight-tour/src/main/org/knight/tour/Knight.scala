package org.knight.tour

final case class Knight(position: Position) {
  def nextPositions(boardDimension: Int): Set[Position] = {
    val pos1 = Position(this.position.x - 2, this.position.y - 1)
    val pos2 = Position(this.position.x - 1, this.position.y - 2)
    val pos3 = Position(this.position.x - 2, this.position.y + 1)
    val pos4 = Position(this.position.x - 1, this.position.y + 2)
    val pos5 = Position(this.position.x + 2, this.position.y - 1)
    val pos6 = Position(this.position.x + 2, this.position.y + 1)
    val pos7 = Position(this.position.x + 1, this.position.y - 2)
    val pos8 = Position(this.position.x + 1, this.position.y + 2)
    Set(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8).filter(
      pos => pos.x >= 0 && pos.x < boardDimension && pos.y >= 0 && pos.y < boardDimension
    )
  }
}

object Knight {
  def apply(x: Int, y: Int): Knight = new Knight(Position(x, y))
}
