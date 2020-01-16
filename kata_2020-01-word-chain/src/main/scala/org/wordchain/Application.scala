package org.wordchain

object Application {

  def main(args: Array[String]): Unit = {
    val input = InputReader.read("words.txt")

    println("cat -> dog")
    val usableWordsExample1 = input(3).toSet.diff(Set("cat"))
    val result1 = WordProcessor.getTransition("cat", "dog", usableWordsExample1)
    println(result1)

    // First example works, 2. Example takes really long (I don't know if it will terminate :/ )
    println("duck -> ruby")
    val usableWordsExample2 = input(4).toSet.diff(Set("duck"))
    val result2 = WordProcessor.getTransition("cat", "dog", usableWordsExample2)
    println(result2)
  }
}
