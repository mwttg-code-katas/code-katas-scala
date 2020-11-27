package org.happy.number

import scala.annotation.tailrec

object HappyNumber {

  private def square(x: Long): Long = x * x

  private def createSum(number: Long): Long = {
    @tailrec
    def helper(remainingNumber: Long, accumulator: Long): Long =
      if (remainingNumber == 0) {
        accumulator
      } else {
        val x  = remainingNumber % 10
        val x2 = square(x)
        helper(remainingNumber / 10, accumulator + x2)
      }

    helper(number, 0)
  }

  private def amIHappy(number: Long): Boolean = {
    @tailrec
    def helper(nextNumber: Long, history: Set[Long]): Boolean =
      if (nextNumber == 1) {
        true
      } else if (history.contains(nextNumber)) {
        false
      } else {
        val newNextNumber = createSum(nextNumber)
        val newResults    = history + nextNumber

        helper(newNextNumber, newResults)
      }

    helper(number, Set.empty[Long])
  }

  def findHappyNumbers(amount: Int): List[Long] = {
    @tailrec
    def helper(number: Long, results: List[Long]): List[Long] =
      if (results.size == amount) {
        results
      } else {
        val maybeHappy = amIHappy(number)
        val newResults = if (maybeHappy) results :+ number else results

        helper(number + 1, newResults)
      }

    helper(1, List.empty[Long])
  }
}
