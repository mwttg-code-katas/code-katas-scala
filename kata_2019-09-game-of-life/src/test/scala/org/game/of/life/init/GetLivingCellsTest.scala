package org.game.of.life.init

import org.scalatest.{ Matchers, WordSpec }

class GetLivingCellsTest extends WordSpec with Matchers {
  "GetLivingCells" should {
    "return a Set of the cells alive" in {
      val input     = List("*..", ".*.", "..*")
      val boardSize = BoardSize(3, 3)
      val actual    = GetLivingCells.get(input, boardSize)
      actual shouldBe Set(Cell(0, 0), Cell(1, 1), Cell(2, 2))
    }
  }
}
