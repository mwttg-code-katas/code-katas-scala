package org.wordchain

object Application {

  def main(args: Array[String]): Unit = {
    val s1    = System.currentTimeMillis()
    val words = InputReader.read("words.txt")
    val e1    = System.currentTimeMillis()
    println(s"getting the input and preparing it took ${e1 - s1} ms")
    println("---------------------")

    calculateChain("cat", "dog", words)
    calculateChain("duck", "ruby", words)
    calculateChain("rust", "java", words)
    calculateChain("rogue", "peach", words)
    calculateChain("null", "funk", words)
  }

  private def calculateChain(from: String, to: String, wordsByLength: Map[Int, List[String]]): Unit = {
    require(from.length == to.length)
    val start       = System.currentTimeMillis()
    val length      = from.length
    val usableWords = wordsByLength(length).toSet.diff(Set(from))
    println(s"$from -> $to    usable words = ${usableWords.size}")
    val result = WordProcessor.getTransition(from, to, usableWords)
    val stop   = System.currentTimeMillis()
    println(result)
    println(s"from $from -> $to took ${stop - start} ms.")
    println("---------------------")
  }
}
