package org.four.is.magic

import scala.annotation.tailrec

object ExtractThreeDigitGroups {

  def from(number: Long): List[Int] = {
    @tailrec
    def helper(restNumber: Long, accumulator: List[Int]): List[Int] = {
      if (restNumber == 0) {
        return accumulator
      }

      val threeDigitGroup = restNumber % 1000
      val newRestNumber   = restNumber / 1000
      helper(newRestNumber.toInt, accumulator :+ threeDigitGroup.toInt)
    }

    helper(number, List.empty)
  }
}
