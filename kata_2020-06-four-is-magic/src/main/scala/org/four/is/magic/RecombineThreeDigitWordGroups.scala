package org.four.is.magic

import scala.annotation.tailrec

object RecombineThreeDigitWordGroups {

  def combine(threeDigitWordGroups: List[String]): String = {
    @tailrec
    def helper(remainingGroups: List[String], numberOfThreeDigitGroup: Int, accumulator: String): String = {
      if (remainingGroups.isEmpty) {
        return accumulator
      }

      val groupText = remainingGroups.head
      val newAccumulator = if (groupText.isEmpty) {
        accumulator
      } else {
        groupText + " " + Scale(numberOfThreeDigitGroup) + " " + accumulator
      }

      helper(
        remainingGroups.drop(1),
        numberOfThreeDigitGroup + 1,
        newAccumulator.trim
      )
    }

    helper(threeDigitWordGroups, 0, "")
  }

  private val Scale = Map(
    0 -> "",
    1 -> "thousand",
    2 -> "million",
    3 -> "billion"
  )
}
