package org.sudoku2
import org.sudoku2.helper.ListHelper.SudokuImprovement

object Sudoku extends App {
  val sudoku = Loader.loadSudoku("sudoku.txt")
  println("Trying to solve:")
  sudoku.prettyPrint()
  println
  val solution = Solver.solveSudoku(sudoku)
  println("Solution:")
  solution.prettyPrint()
}
