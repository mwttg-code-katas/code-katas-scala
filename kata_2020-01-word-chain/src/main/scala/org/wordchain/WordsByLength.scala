package org.wordchain

object WordsByLength {
  def get(lines: List[String]): Map[Int, List[String]] = {
    lines.foldLeft(Map.empty[Int, List[String]]) { (accumulator, word)  => {
      val wordLength = word.length
      if (accumulator.keySet.contains(wordLength)) {
        val words = accumulator(wordLength)
        val newList = words :+ word
        accumulator + (wordLength -> newList)
      } else {
        accumulator + (wordLength -> List(word))
      }
    }}
  }
}
