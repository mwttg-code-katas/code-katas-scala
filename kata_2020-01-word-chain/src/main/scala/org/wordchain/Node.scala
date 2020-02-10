package org.wordchain

final case class Node(parent: Option[Node], word: String) {
  import Node._

  def createChildren(usableWords: Set[String], to: String, alreadySeenWords: AlreadySeenWords): Set[Node] = {
    val maybeChildren = getAllDiffByOne(this.word, usableWords)
    val children = compareMaybeChildrenWithTarget(to, maybeChildren)
    val wordsForCheck = children.diff(alreadySeenWords.getWords)
    wordsForCheck.map(word => Node(Some(this), word))
  }
}

object Node {
  private def compareMaybeChildrenWithTarget(to: String, maybeChildren: Set[String]) = {
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
    val moreWords = if (diffs.contains(minDiff + 1)) diffs(minDiff + 1) else Set.empty[String]
    diffs(minDiff).union(moreWords)
  }

  private def getAllDiffByOne(word: String, usableWords: Set[String]) =
    usableWords.filter(filterWord => compareWords(word, filterWord) == 1)

  private def compareWords(word: String, otherWord: String) = {
    word
      .zip(otherWord)
      .map(
        tuple =>
          if (tuple._1 == tuple._2) {
            0
          } else {
            1
        }
      ).sum
  }
}
