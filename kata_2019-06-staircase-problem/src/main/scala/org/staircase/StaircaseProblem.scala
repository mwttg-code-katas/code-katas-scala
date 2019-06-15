package org.staircase

import org.staircase.Staircase.numWays

object StaircaseProblem extends App {
  println("--- Task One ---")
  println(s"A staircase with 7 stairs has ${numWays(7)} number of ways to get up with 1 or 2 steps.")

  println("   Bonus:")
  val result = Staircase.numWaysWithWays(7)
  println("    the actual ways are:")
  result._2.foreach(println)
}
