package org.wordchain

final case class AlreadySeenWords(words: Set[String]) {
  def add(words: Set[String]): AlreadySeenWords = {
    AlreadySeenWords(this.words.union(words))
  }

  def getWords: Set[String] = {
    this.words
  }
}

object AlreadySeenWords {
  def apply(): AlreadySeenWords = new AlreadySeenWords(Set.empty[String])
}
