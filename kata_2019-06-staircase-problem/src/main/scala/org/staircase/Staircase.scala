package org.staircase

import org.staircase.Factorial.factorial

import scala.annotation.tailrec

object Staircase {
  def combinations: (Int, Int) => Int =
    (amountOfNumberOne, amountOfNumberTwo) =>
      factorial(amountOfNumberOne + amountOfNumberTwo) / (factorial(amountOfNumberOne) * factorial(amountOfNumberTwo))

  def numWays(stairs: Int): Int = {
    @tailrec
    def helper(amountOfNumberOne: Int, amountOfNumberTwo: Int, accumulator: Int): Int =
      (amountOfNumberOne, amountOfNumberTwo) match {
        case (_, i) if i < 0 => accumulator
        case (n, m) =>
          val possibilities = combinations(n, m)
          helper(n + 2, m - 1, accumulator + possibilities)
      }

    helper(stairs - (stairs / 2 * 2), stairs / 2, 0)
  }

  def numWaysWithWays(stairs: Int): (Int, Iterator[List[Int]]) = {
    @tailrec
    def helper(amountOfNumberOne: Int,
               amountOfNumberTwo: Int,
               accumulator: (Int, Iterator[List[Int]])): (Int, Iterator[List[Int]]) =
      (amountOfNumberOne, amountOfNumberTwo) match {
        case (_, i) if i < 0 => accumulator
        case (n, m) =>
          val possibilities = combinations(n, m)
          val ways          = (List.fill(n)(1) ::: List.fill(m)(2)).permutations
          helper(
            n + 2,
            m - 1,
            (accumulator._1 + possibilities, accumulator._2 ++ ways)
          )
      }

    helper(stairs - (stairs / 2 * 2), stairs / 2, (0, Iterator.empty))
  }
}
