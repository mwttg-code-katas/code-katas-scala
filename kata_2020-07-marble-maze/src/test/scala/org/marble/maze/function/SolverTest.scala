package org.marble.maze.function

import org.scalatest.{ Matchers, WordSpec }

class SolverTest extends WordSpec with Matchers {

 "Solver" should {
   "solve a level" in {

     val level = Playground.createFrom("playground-example5.txt")
     val solution = Solver.solveLevel(level)

     println(solution)
     // Well this is not really a test ;)
   }
 }
}
