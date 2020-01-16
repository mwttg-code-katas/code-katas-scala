package org.wordchain

object Application {

  def main(args: Array[String]): Unit = {
    val s1 = System.currentTimeMillis()
    val input = InputReader.read("words.txt")
    val e1 = System.currentTimeMillis()
    println(s"getting the input and preparing it took ${e1-s1} ms")
    println("---------------------")

    val s2 = System.currentTimeMillis()
    val usableWordsExample1 = input(3).toSet.diff(Set("cat"))
    println(s"cat -> dog   usableWords: ${usableWordsExample1.size}")
    val result1 = WordProcessor.getTransition("cat", "dog", usableWordsExample1)
    val e2 = System.currentTimeMillis()
    println(result1)
    println(s"from 'cat' -> 'dog' took ${e2-s2} ms")
    println("---------------------")

    val s3 = System.currentTimeMillis()
    val usableWordsExample2 = input(4).toSet.diff(Set("duck"))
    println(s"duck -> ruby   usableWords: ${usableWordsExample2.size}")
    val result2 = WordProcessor.getTransition("duck", "ruby", usableWordsExample2)
    val e3 = System.currentTimeMillis()
    println(result2)
    println(s"from 'duck' -> 'ruby' took ${e3-s3} ms")
  }
}
