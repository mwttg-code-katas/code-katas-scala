package org.wordchain

final case class Node(parent: Option[Node], word: String) {
  import Node._

  def createChildren(usableWords: Set[String]): Set[Node] = {
    val resultWords = getAllDiffByOne(this.word, usableWords)
    resultWords.map(word => Node(Some(this), word))
  }
}

object Node {
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
