package org.wordchain

import scala.annotation.tailrec

object WordProcessor {

  def getTransition(from: String, to: String, usableWords: Set[String]): List[String] = {
    val treeLevels = createTreeLevels(from, to, usableWords)
    val lastLevel  = treeLevels.keys.max
    val targetNode = treeLevels(lastLevel).find(node => node.word == to) match {
      case Some(x) => x
    }
    from +: getTransitionWay(targetNode)
  }

  private def getTransitionWay(targetNode: Node) = {
    @tailrec
    def helper(currentNode: Node, accumulator: List[String]): List[String] =
      if (currentNode.parent.isEmpty) {
        accumulator.reverse
      } else {
        val parent = currentNode.parent match {
          case Some(p) => p
        }
        helper(parent, accumulator :+ currentNode.word)
      }

    helper(targetNode, List.empty[String])
  }

  private def createTreeLevels(from: String, to: String, usableWords: Set[String]) = {
    val wordLength = to.length

    @tailrec
    def helper(currentNodes: Set[Node], currentLevel: Int, accumulator: Map[Int, Set[Node]]): Map[Int, Set[Node]] =
      if (accumulator(currentLevel).exists(node => node.word == to)) {
        accumulator
      } else {
        val newLevel       = currentLevel + 1
        val maxDifference = wordLength - newLevel - 1
        val allChildren    = createNextTreeLevel(currentNodes, usableWords, to, maxDifference)
        val newAccumulator = accumulator + (newLevel -> allChildren)
        helper(allChildren, newLevel, newAccumulator)
      }

    val root    = Node(None, from)
    val rootSet = Set(root)
    helper(rootSet, 0, Map(0 -> rootSet))
  }

  private def createNextTreeLevel(nodes: Set[Node], usableWords: Set[String], to: String, maxDifference: Int) =
    nodes.flatMap(node => node.createChildren(usableWords, to, maxDifference))
}
