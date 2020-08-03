package org.marble.maze

import org.marble.maze.function.{ Playground, Solver }

object Application {

  def main(args: Array[String]): Unit = {
    val levels = Seq(
      "test-falling-down.txt",
      "test-goes-left.txt",
      "test-goes-right.txt",
      "test-split.txt",
      "test-merge.txt",
      "test-no-solution.txt",
      "test-multiple-ways.txt",
      "test-marble-dont-jump-left.txt",
      "test-marble-dont-jump-right.txt",
      "test-marble-dont-jump-up.txt",
      "test-bigspace.txt",
      "level-1.txt",
      "level-2.txt"
    )

    levels.foreach(level => solveLevel(level))
  }

  private def solveLevel(levelName: String): Unit ={
    println(s"solving level .... $levelName")
    val level    = Playground.createFrom(levelName)
    val solution = Solver.solveLevel(level)
    val x        = solution._1.zip(solution._2)
    x.foreach(tuple => println(s"input: ${tuple._1} has the following outputs: ${tuple._2}"))
    println
  }
}
