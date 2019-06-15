package org.staircase

import scala.annotation.tailrec

object Factorial {
  def factorial(n: Int): Int = {
    @tailrec
    def helper(i: Int, accumulator: Int): Int =
      i match {
        case 0 => accumulator
        case _ => helper(i - 1, accumulator * i)
      }
    helper(n, 1)
  }
}
