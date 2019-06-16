package org.staircase

object StaircaseTask2Problem extends App {
  println("Task 2 with Bonus")
  val result1 = StaircaseTask2.numWays(7, List(1, 2))
  println("A staircase with 7 stairs and the possibility to take one or two steps has")
  println(s"${result1._1} different ways to climb up")
  println("the actual ways are:")
  result1._2.foreach(println)

  val stairs = 7
  val steps  = List(1, 2, 3, 4)

  println("-----------------")
  val result2 = StaircaseTask2.numWays(stairs, steps)
  println(s"A staircase with $stairs stairs and the possibility to take the following steps $steps has")
  println(s"${result2._1} different ways to climb up")
  println("the actual ways are:")
  result2._2.foreach(println)
}
