package org.knight.tour

import scala.annotation.tailrec

final case class Position(x: Int, y: Int)

final case class Result(amountOfTours: Int, tours: Set[List[Position]])

object Tour {
  def knightTours(dimension: Int, startNode: Node): Result = {
    val tourTree = calculateTours(dimension, startNode)
    val maxLevel = tourTree.keySet.max
    val toursEndpoints = tourTree(maxLevel)
    val tours = toursEndpoints.map(item => extractWayPoints(item))
    Result(tours.size, tours)
  }

  private def calculateTours(dimension: Int, startNode: Node): Map[Int, Set[Node]] = {
    @tailrec
    def helper(level: Int, currentNodes: Set[Node], accumulator: Map[Int, Set[Node]]): Map[Int, Set[Node]] = {
      if (level == (dimension * dimension) - 1) { // counting from 0
         accumulator
      } else {
        val newLevelNodes = currentNodes.flatMap(item => item.createChildren(dimension))
        val newLevel = level + 1
        val newAccumulator = accumulator + (newLevel -> newLevelNodes)
        helper(newLevel, newLevelNodes, newAccumulator)
      }
    }

    helper(0, Set(startNode), Map(0 -> Set(startNode)))
  }

  // Well functional programming looks different ;)
  private def extractWayPoints(node: Node): List[Position] = {
    var varNode = node
    var result = List.empty[Position]
    while (varNode.parent.isDefined) {
      val position = varNode.position
      result = result :+ position
      varNode = varNode.parent.get
    }
    result = result :+ varNode.position
    result.reverse
  }
}
