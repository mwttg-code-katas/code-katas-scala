package org.wordchain

final case class Node(parent: Option[Node], word: String) {
  import Node._

  def createChildren(usableWords: Set[String], to: String, maxDifference: Int): Set[Node] = {
    val maybeChildren = getAllDiffByOne(this.word, usableWords)
    val children = compareMaybeChildrenWithTarget(maxDifference, to, maybeChildren)
    children.map(word => Node(Some(this), word))
  }
}

object Node {
  private def compareMaybeChildrenWithTarget(maxDiff: Int, to: String, maybeChildren: Set[String]) = {
    val diffs = maybeChildren.foldLeft(Map.empty[Int, Set[String]]) {(accumulator, word) => {
      val diff = compareWords(to, word)
      if (accumulator.contains(diff)) {
        val values = accumulator(diff)
        val newValues = values + word
        accumulator + (diff -> newValues)
      } else {
        accumulator + (diff -> Set(word))
      }
    }}

    val minDiff = diffs.keySet.min
    diffs(minDiff)
  }

  private def getAllDiffByOne(word: String, usableWords: Set[String]) =
    usableWords.filter(filterWord => compareWords(word, filterWord) == 1)

  private def compareWords(word: String, otherWord: String) = {
    val difference = word
      .zip(otherWord)
      .map(
        tuple =>
          if (tuple._1 == tuple._2) {
            0
          } else {
            1
        }
      )
    difference.sum
  }
}
