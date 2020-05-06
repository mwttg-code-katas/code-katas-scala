package org.i.before.e

final case class WordAmounts(ie: Int, cie: Int, cei: Int, ei: Int) {
  def add(ieAmounts: WordAmounts, eiAmounts: WordAmounts): WordAmounts =
    WordAmounts(
      this.ie + ieAmounts.ie + eiAmounts.ie,
      this.cie + ieAmounts.cie + eiAmounts.cie,
      this.cei + ieAmounts.cei + eiAmounts.cei,
      this.ei + ieAmounts.ei + eiAmounts.ei,
    )

  def prettyPrint(): Unit = {
    println(s"ie=${this.ie} cie=${this.cie} cei=${this.cei} ei=${this.ei}")
    println(s"The first sentence 'ie > 2 * cie' is ${this.ie > 2 * this.cie}")
    println(s"The second sentence 'cei > 2 * ei' is ${this.cei > 2 * this.ei}")
  }
}

object WordFilter {
  private def incIe   = WordAmounts(1, 0, 0, 0)
  private def incCie  = WordAmounts(0, 1, 0, 0)
  private def incCei  = WordAmounts(0, 0, 1, 0)
  private def incEi   = WordAmounts(0, 0, 0, 1)
  private def skipInc = WordAmounts(0, 0, 0, 0)

  def filter(words: List[String]): WordAmounts =
    words.foldLeft(WordAmounts(0, 0, 0, 0)) { (amounts, word) =>
      {
        val ieAmount = countIe(word)
        val eiAmount = countEi(word)
        amounts.add(ieAmount, eiAmount)
      }
    }

  private def countEi(word: String) =
    if (word.contains("ei")) {
      if (word.contains("cei")) {
        incCei
      } else {
        incEi
      }
    } else {
      skipInc
    }

  private def countIe(word: String) =
    if (word.contains("ie")) {
      if (word.contains("cie")) {
        incCie
      } else {
        incIe
      }
    } else {
      skipInc
    }
}
