package org.word.puzzle.task1

object Palindrome {
  def check(word: String): Boolean =
    if (word.isEmpty) {
      false
    } else {
      val parts = split(word)
      parts._1.equalsIgnoreCase(parts._2.reverse)
    }

  private[task1] def split(word: String) =
    if (word.length % 2 == 0) {
      word.splitAt(word.length / 2)
    } else {
      val newWord = new StringBuilder(word).deleteCharAt(word.length / 2).mkString
      newWord.splitAt(newWord.length / 2)
    }
}
