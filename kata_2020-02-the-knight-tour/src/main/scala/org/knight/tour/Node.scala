package org.knight.tour

final case class Node(parent: Option[Node], position: Position, alreadyVisit: Set[Position]) {
  def createChildren(boardDimension: Int): Set[Node] = {
    val maybeNextPositions = Knight(this.position).nextPositions(boardDimension)
    val nextPositions = maybeNextPositions.diff(this.alreadyVisit)
    nextPositions.map(item => Node(Some(this), item, this.alreadyVisit + item))
  }
}
