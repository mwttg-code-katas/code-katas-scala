package org.sudoku2

import org.scalatest.{ Matchers, WordSpec }
import org.sudoku2.helper.ListHelper.SudokuImprovement

class ListHelperTest extends WordSpec with Matchers {
  "ListHelper" should {
    "extract a row with index 0" in {
      val data   = Mocks.sudokuBoard
      val actual = data.row(0)
      actual shouldBe List(
        Field(Some(1), Set.empty),
        Field(Some(2), Set.empty),
        Field(Some(3), Set.empty),
        Field(Some(4), Set.empty),
        Field(Some(5), Set.empty),
        Field(Some(6), Set.empty),
        Field(Some(7), Set.empty),
        Field(Some(8), Set.empty),
        Field(Some(9), Set.empty)
      )
    }
    "extract a row with index 1" in {
      val data   = Mocks.sudokuBoard
      val actual = data.row(1)
      actual shouldBe List(
        Field(Some(10), Set.empty),
        Field(Some(11), Set.empty),
        Field(Some(12), Set.empty),
        Field(Some(13), Set.empty),
        Field(Some(14), Set.empty),
        Field(Some(15), Set.empty),
        Field(Some(16), Set.empty),
        Field(Some(17), Set.empty),
        Field(Some(18), Set.empty)
      )
    }
    "extract a row with index 8" in {
      val data   = Mocks.sudokuBoard
      val actual = data.row(8)
      actual shouldBe List(
        Field(Some(73), Set.empty),
        Field(Some(74), Set.empty),
        Field(Some(75), Set.empty),
        Field(Some(76), Set.empty),
        Field(Some(77), Set.empty),
        Field(Some(78), Set.empty),
        Field(Some(79), Set.empty),
        Field(Some(80), Set.empty),
        Field(Some(81), Set.empty)
      )
    }
    "extract a column with index 0" in {
      val data   = Mocks.sudokuBoard
      val actual = data.column(0)
      actual shouldBe List(
        Field(Some(1), Set.empty),
        Field(Some(10), Set.empty),
        Field(Some(19), Set.empty),
        Field(Some(28), Set.empty),
        Field(Some(37), Set.empty),
        Field(Some(46), Set.empty),
        Field(Some(55), Set.empty),
        Field(Some(64), Set.empty),
        Field(Some(73), Set.empty)
      )
    }
    "extract a column with index 1" in {
      val data   = Mocks.sudokuBoard
      val actual = data.column(1)
      actual shouldBe List(
        Field(Some(2), Set.empty),
        Field(Some(11), Set.empty),
        Field(Some(20), Set.empty),
        Field(Some(29), Set.empty),
        Field(Some(38), Set.empty),
        Field(Some(47), Set.empty),
        Field(Some(56), Set.empty),
        Field(Some(65), Set.empty),
        Field(Some(74), Set.empty)
      )
    }
    "extract a column with index 8" in {
      val data   = Mocks.sudokuBoard
      val actual = data.column(8)
      actual shouldBe List(
        Field(Some(9), Set.empty),
        Field(Some(18), Set.empty),
        Field(Some(27), Set.empty),
        Field(Some(36), Set.empty),
        Field(Some(45), Set.empty),
        Field(Some(54), Set.empty),
        Field(Some(63), Set.empty),
        Field(Some(72), Set.empty),
        Field(Some(81), Set.empty)
      )
    }
    "extract a square with index 0" in {
      val data   = Mocks.sudokuBoard
      val actual = data.square(0)
      actual shouldBe List(
        Field(Some(1), Set.empty),
        Field(Some(2), Set.empty),
        Field(Some(3), Set.empty),
        Field(Some(10), Set.empty),
        Field(Some(11), Set.empty),
        Field(Some(12), Set.empty),
        Field(Some(19), Set.empty),
        Field(Some(20), Set.empty),
        Field(Some(21), Set.empty)
      )
    }
    "extract a square with index 4" in {
      val data   = Mocks.sudokuBoard
      val actual = data.square(4)
      actual shouldBe List(
        Field(Some(31), Set.empty),
        Field(Some(32), Set.empty),
        Field(Some(33), Set.empty),
        Field(Some(40), Set.empty),
        Field(Some(41), Set.empty),
        Field(Some(42), Set.empty),
        Field(Some(49), Set.empty),
        Field(Some(50), Set.empty),
        Field(Some(51), Set.empty)
      )
    }
    "extract a square with index 8" in {
      val data   = Mocks.sudokuBoard
      val actual = data.square(8)
      actual shouldBe List(
        Field(Some(61), Set.empty),
        Field(Some(62), Set.empty),
        Field(Some(63), Set.empty),
        Field(Some(70), Set.empty),
        Field(Some(71), Set.empty),
        Field(Some(72), Set.empty),
        Field(Some(79), Set.empty),
        Field(Some(80), Set.empty),
        Field(Some(81), Set.empty)
      )
    }
    "test prettyPrint" in {
      val data = Mocks.sudokuBoard
      data.prettyDebugPrint()
    }
  }
}
