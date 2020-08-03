package org.marble.maze.function

import scala.annotation.tailrec

final case class Solution(inputs: Seq[Set[Int]], outputs: Seq[Set[Int]])

object Solver {

  def solveLevel(level: Seq[Seq[Boolean]]): (Seq[Set[Int]], Seq[Set[Int]]) = {
    @tailrec
    def helper(restLevel: Seq[Seq[Boolean]], lastRow: Seq[Boolean], marbleIns: Seq[Set[Int]]): Seq[Set[Int]] =
      if (restLevel.isEmpty) {
        marbleIns
      } else {
        val currentRow = restLevel.head
        val newMarbleIns = marbleIns.map(
          inputNumber => inputNumber.flatMap(input => getOutputForIndex(input, currentRow, lastRow))
        )
        helper(restLevel.drop(1), currentRow, newMarbleIns)
      }

    val lastRow   = level.head
    val restLevel = level.drop(1)
    val marbleIns = lastRow.zipWithIndex.filter(tuple => tuple._1).map(tuple => Set(tuple._2))
    val solution = helper(restLevel, lastRow, marbleIns)
    (marbleIns, solution)
  }

  private def getOutputForIndex(inIndex: Int, row: Seq[Boolean], lastRow: Seq[Boolean]): Set[Int] = {
    val currentRowWithIndex = row.zipWithIndex
    if (currentRowWithIndex.contains((true, inIndex))) { // marble can fall down
      return Set(inIndex) // we are done
    }

    val left  = findOutputToLeft(inIndex, row, lastRow)
    val right = findOutputToRight(inIndex, row, lastRow)

    (left, right) match {
      case (Some(l), Some(r)) => Set(l, r)
      case (None, Some(r)) => Set(r)
      case (Some(l), None) => Set(l)
      case (None, None) => Set.empty[Int]
    }
  }

  private def findOutputToLeft(index: Int, row: Seq[Boolean], lastRow: Seq[Boolean]): Option[Int] = {
    val currentRowWithIndex = row.zipWithIndex
    val maybeOutputs        = currentRowWithIndex.filter(tuple => tuple._1 && tuple._2 < index).sorted
    if (maybeOutputs.isEmpty) { // no way to the left
      return Option.empty
    }

    val outIndex = maybeOutputs.last // way to the left, but not connected with output index
    if (!isConnected(index, outIndex._2, lastRow)) {
      return Option.empty
    }

    Option(outIndex._2)
  }

  private def findOutputToRight(index: Int, row: Seq[Boolean], lastRow: Seq[Boolean]): Option[Int] = {
    val currentRowWithIndex = row.zipWithIndex
    val maybeOutputs        = currentRowWithIndex.filter(tuple => tuple._1 && tuple._2 > index).sorted
    if (maybeOutputs.isEmpty) { // no way to the right
      return Option.empty
    }

    val outIndex = maybeOutputs.head // way to the right, but not connected with output index
    if (!isConnected(index, outIndex._2, lastRow)) {
      return Option.empty
    }

    Option(outIndex._2)
  }

  private def isConnected(inIndex: Int, outIndex: Int, row: Seq[Boolean]): Boolean = {
    val rowWithIndex = row.zipWithIndex
    val connectedElements = if (inIndex < outIndex) {
      rowWithIndex.count(tuple => tuple._1 && tuple._2 <= outIndex && tuple._2 >= inIndex)
    } else {
      rowWithIndex.count(tuple => tuple._1 && tuple._2 >= outIndex && tuple._2 <= inIndex)
    }
    (inIndex - outIndex).abs + 1 == connectedElements
  }
}
