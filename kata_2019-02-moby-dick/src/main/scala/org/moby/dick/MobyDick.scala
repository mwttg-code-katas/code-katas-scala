package org.moby.dick

import scala.collection.immutable.ListMap

object MobyDick extends App {
  val filename = "mobydick.txt"

  val top20 = Top20.get(filename)
  prettyPrint(top20)

  println

  val top21 = Top21.get(filename)
  prettyPrint(top21)

  private def prettyPrint(top: ListMap[String, Int]): Unit = {
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
  }
}
