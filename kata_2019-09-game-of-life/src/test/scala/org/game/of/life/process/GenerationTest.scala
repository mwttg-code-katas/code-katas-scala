package org.game.of.life.process

import org.scalatest.{ Matchers, WordSpec }

class GenerationTest extends WordSpec with Matchers {
  "Generation" should {
    "initialize generation zero (no cell alive)" in {
      val boardSize = BoardSize(5, 3)
      val lines     = List(".....", ".....", ".....")
      Generation.zero(lines, boardSize) shouldBe Set.empty[Cell]
    }
    "initialize generation zero (one cell alive)" in {
      val boardSize = BoardSize(5, 3)
      val lines     = List(".....", "..*..", ".....")
      Generation.zero(lines, boardSize) shouldBe Set(Cell(2, 1))
    }
    "initialize generation zero (one other cell alive)" in {
      val boardSize = BoardSize(5, 3)
      val lines     = List(".....", ".....", "...*.")
      Generation.zero(lines, boardSize) shouldBe Set(Cell(3, 2))
    }
    "initialize generation zero (three cells alive)" in {
      val boardSize = BoardSize(5, 3)
      val lines     = List(".*...", ".....", ".*.*.")
      Generation.zero(lines, boardSize) shouldBe Set(Cell(1, 0), Cell(1, 2), Cell(3, 2))
    }
    "generate the next generation (dying rule: living neighbour cells < 2)" in {
      val boardSize   = BoardSize(5, 5)
      val livingCells = Set(Cell(1, 1), Cell(2, 1))
      Generation.next(livingCells, boardSize) shouldBe Set.empty[Cell]
    }
    "generate the next generation (birth rule: living neighbour cells = 3)" in {
      val boardSize = BoardSize(5, 5)
      val livingCells = Set(
        Cell(1, 2),
        Cell(2, 2),
        Cell(3, 2)
      )
      Generation.next(livingCells, boardSize) shouldBe Set(
        Cell(2, 1),
        Cell(2, 2),
        Cell(2, 3)
      )
    }
    "generate the next generation (nothing happens rule: living neighbour cells = 3 || 2)" in {
      val boardSize = BoardSize(5, 5)
      val livingCells = Set(
        Cell(1, 2),
        Cell(2, 2),
        Cell(1, 3),
        Cell(2, 3)
      )
      Generation.next(livingCells, boardSize) shouldBe Set(
        Cell(1, 2),
        Cell(2, 2),
        Cell(1, 3),
        Cell(2, 3)
      )
    }
  }
}
