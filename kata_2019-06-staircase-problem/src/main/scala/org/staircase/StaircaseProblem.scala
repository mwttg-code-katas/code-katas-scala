package org.staircase

import org.staircase.Staircase.numWays

object StaircaseProblem extends App {
  val stairs = 14
  println("--- Task One ---")
  println(s"A staircase with $stairs stairs has ${numWays(stairs)} number of ways to get up with 1 or 2 steps.")

  println("   Bonus:")
  val result = Staircase.numWaysWithWays(stairs)
  println(s"    found ${result._1} ways to climb up the staircase")
  println("    the actual ways are:")
  result._2.foreach(println)
}
