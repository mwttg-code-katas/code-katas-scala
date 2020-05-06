package org.i.before.e

object Application {
  def main(args: Array[String]): Unit = {
    val words = Utilities.readFile("words.txt")
    val amounts = WordFilter.filter(words)
    amounts.prettyPrint()

    val wordsWithFreq = Utilities.readFileWithFrequencies("words-with-frequencies.txt")
    val amountsWithFreq = WordFilterWithFrequencies.filter(wordsWithFreq)
    amountsWithFreq.prettyPrint()
  }
}
