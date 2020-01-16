package org.wordchain

object Application {

  def main(args: Array[String]): Unit = {
    val input = InputReader.read("words.txt")

    val usableWordsExample1 = input(3).toSet.diff(Set("cat"))
    println(s"cat -> dog   usableWords: ${usableWordsExample1.size}")
    val result1 = WordProcessor.getTransition("cat", "dog", usableWordsExample1)
    println(result1)
    
    val usableWordsExample2 = input(4).toSet.diff(Set("duck"))
    println(s"duck -> ruby   usableWords: ${usableWordsExample2.size}")
    val result2 = WordProcessor.getTransition("duck", "ruby", usableWordsExample2)
    println(result2)
  }
}
