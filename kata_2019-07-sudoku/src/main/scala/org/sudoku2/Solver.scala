package org.sudoku2

import org.sudoku2.helper.ListHelper.SudokuImprovement

import scala.annotation.tailrec

object Solver {

  @tailrec
  def solveSudoku(sudoku: List[Field]): List[Field] =
    if (hasUnsolvedField(sudoku)) {
      val guess         = SolveStep.checkBoard(sudoku)
      val newSudokuStep = SolveStep.solveBoard(guess)
      // newSudokuStep.prettyPrint()
      // println
      solveSudoku(newSudokuStep)
    } else {
      sudoku
    }

  private def hasUnsolvedField(sudoku: List[Field]) = {
    @tailrec
    def helper(xs: List[Field], accumulator: Boolean): Boolean =
      xs match {
        case Nil => accumulator
        case head :: tail =>
          head.value match {
            case Some(_) => helper(tail, accumulator || false)
            case None => helper(tail, accumulator || true)
          }
      }
    helper(sudoku, false)
  }

  object SolveStep {
    private val AllNumbers = (1 to 9).toSet
    private val Index      = (0 to 8).toList

    def solveBoard(sudoku: List[Field]): List[Field] =
      for (y <- Index;
           x <- Index) yield {
        solveField(sudoku, x, y)
      }

    private def solveField(sudoku: List[Field], x: Int, y: Int) =
      sudoku.getField(x, y) match {
        case Field(Some(v), e) => Field(Some(v), e)
        case Field(None, s) =>
          s.size match {
            case 1 => Field(Some(s.head), Set.empty)
            case _ => Field(None, s)
          }
      }

    def checkBoard(sudoku: List[Field]): List[Field] =
      for (y <- Index;
           x <- Index) yield {
        checkField(sudoku, x, y)
      }

    private def checkField(sudoku: List[Field], x: Int, y: Int) =
      sudoku.getField(x, y).value match {
        case Some(v) => Field(Some(v), Set.empty)
        case None => processField(sudoku, x, y)
      }

    private def processField(sudoku: List[Field], x: Int, y: Int) = {
      val used  = getUsedNumbers(sudoku, x, y)
      val free  = getFreeNumbers(used)
      val value = sudoku.getField(x, y).value
      Field(value, free)
    }

    private def getUsedNumbers(sudoku: List[Field], x: Int, y: Int) = {
      val index  = (x / 3) + ((y / 3) * 3)
      val column = sudoku.column(x).flatMap(_.value)
      val row    = sudoku.row(y).flatMap(_.value)
      val square = sudoku.square(index).flatMap(_.value)
      (column ::: row ::: square).toSet
    }

    private def getFreeNumbers(usedNumbers: Set[Int]) =
      AllNumbers.diff(usedNumbers)
  }
}
