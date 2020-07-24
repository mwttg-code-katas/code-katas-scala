package org.marble.maze.function

import org.scalatest.{ Matchers, WordSpec }

class SolverTest extends WordSpec with Matchers {

  "Position#getStartPositions" should {
    "extract the start positions of a row" in {
      val input  = Seq(false, true, false, false, false, true, false)
      val actual = Solver.getStartPositions(input)
      actual should contain theSameElementsInOrderAs Seq(Solver(1, 0), Solver(5, 0))
    }
  }
}
