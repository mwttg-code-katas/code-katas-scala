package org.i.before.e

object WordFilterWithFrequencies {
  private def incIe(freq: Int)  = WordAmounts(freq, 0, 0, 0)
  private def incCie(freq: Int) = WordAmounts(0, freq, 0, 0)
  private def incCei(freq: Int) = WordAmounts(0, 0, freq, 0)
  private def incEi(freq: Int)  = WordAmounts(0, 0, 0, freq)
  private def skipInc           = WordAmounts(0, 0, 0, 0)

  def filter(words: List[Line]): WordAmounts =
    words.foldLeft(WordAmounts(0, 0, 0, 0)) { (amounts, wordWithFreq) =>
      {
        val ieAmount = countIeWithFreq(wordWithFreq)
        val eiAmount = countEiWithFreq(wordWithFreq)
        amounts.add(ieAmount, eiAmount)
      }
    }

  private def countEiWithFreq(line: Line) =
    if (line.word.contains("ei")) {
      if (line.word.contains("cei")) {
        incCei(line.frequency)
      } else {
        incEi(line.frequency)
      }
    } else {
      skipInc
    }

  private def countIeWithFreq(line: Line) =
    if (line.word.contains("ie")) {
      if (line.word.contains("cie")) {
        incCie(line.frequency)
      } else {
        incIe(line.frequency)
      }
    } else {
      skipInc
    }
}
