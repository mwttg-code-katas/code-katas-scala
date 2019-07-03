package org.sudoku2.helper

import org.sudoku2.Field

import scala.annotation.tailrec

object ListHelper {
  private val MaxColumns = 9
  private val MaxRows    = 9

  implicit class SudokuImprovement(val list: List[Field]) {
    def row(index: Int): List[Field] = {
      val startIndex = index * MaxColumns
      list.slice(startIndex, startIndex + 9)
    }

    def column(index: Int): List[Field] = {
      @tailrec
      def helper(i: Int, xs: List[Field], accumulator: List[Field]): List[Field] =
        xs match {
          case Nil => accumulator
          case head :: tail =>
            if ((i - index) % MaxColumns == 0)
              helper(i + 1, tail, accumulator :+ head)
            else
              helper(i + 1, tail, accumulator)
        }
      helper(0, list, List.empty)
    }

    def square(index: Int): List[Field] = {
      val startIndex = ((index / 3) * 27) + ((index % 3) * 3)
      val x1         = list.slice(startIndex, startIndex + 3)
      val x2         = list.slice(startIndex + 9, startIndex + 9 + 3)
      val x3         = list.slice(startIndex + 18, startIndex + 18 + 3)
      x1 ::: x2 ::: x3
    }

    def getField(x: Int, y: Int): Field = list(MaxColumns * y + x)

    def prettyDebugPrint(): Unit = {
      val index = (0 to 8).toList
      for (y <- index;
           x <- index) {
        val field = list.getField(x, y)
        print(f"$field%30s")
        if ((x + 1) % 3 == 0 && x != 8) print(" ┃ ")
        if (x == 8) println
        if ((y + 1) % 3 == 0 && x == 8 && y != 8)
          println(
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
          )
      }
    }

    def prettyPrint(): Unit = {
      val index = (0 to 8).toList
      for (y <- index;
           x <- index) {
        val v = list.getField(x, y).value match {
          case Some(a) => a.toString
          case None => "."
        }
        print(f"$v%2s")
        if ((x + 1) % 3 == 0 && x != 8) print(" ┃ ")
        if (x == 8) println
        if ((y + 1) % 3 == 0 && x == 8 && y != 8)
          println(
            "━━━━━━━╋━━━━━━━━╋━━━━━━━━"
          )
      }
    }
  }
}
