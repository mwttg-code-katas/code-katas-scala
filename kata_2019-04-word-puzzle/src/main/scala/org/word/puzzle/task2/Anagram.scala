package org.word.puzzle.task2

object Anagram {
  def check(first: String, second: String): Boolean = {
    val letters1 = first.toLowerCase.groupBy(identity).mapValues(x => x.length)
    val letters2 = second.toLowerCase.groupBy(identity).mapValues(x => x.length)
    letters1 == letters2
  }

  // Order letters compare string (second approach - much better)
  def check2(first: String, second: String): Boolean = {
    val firstOrdered  = first.toLowerCase.sorted
    val secondOrdered = second.toLowerCase.sorted
    firstOrdered == secondOrdered
  }
}
