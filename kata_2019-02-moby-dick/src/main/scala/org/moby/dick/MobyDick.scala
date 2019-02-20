package org.moby.dick

import scala.collection.immutable.ListMap

object MobyDick extends App {
  val filename = "mobydick.txt"

  val startTop20 = System.currentTimeMillis()
  val top20 = Top20.get(filename)
  val stopTop20 = System.currentTimeMillis()
  prettyPrint(top20, startTop20, stopTop20)

  println

  val startTop21 = System.currentTimeMillis()
  val top21 = Top21.get(filename)
  val stopTop21 = System.currentTimeMillis()
  prettyPrint(top21, startTop21, stopTop21)

  private def prettyPrint(top: ListMap[String, Int], start: Long, stop: Long): Unit = {
    def dots(insertWord: String): Unit = {
      val amount = 20 - insertWord.length
      (0 to amount).foreach(i => print('.'))
    }
    top.foreach(tuple => {
      print(s"Word: '${tuple._1}'")
      dots(tuple._1)
      print(s" count: ${tuple._2}")
      println
    })
    println(s"This took ${stop - start} ms.")
  }
}
