package org.water.between.towers

import scala.annotation.tailrec

object Water {

  def getAmount(towers: List[Int]): Int = {
    @tailrec
    def helper(index: Int, accumulator: Int): Int = {
      if (index == towers.size - 1) {
        return accumulator
      }

      if (index < 1) {
        helper(index + 1, accumulator)  // no calculation for the first tower
      } else {
        val (before, behindTemp) = towers.splitAt(index)
        val behind               = behindTemp.tail
        val currentTower         = behindTemp.head

        val maxBefore = before.max
        val maxBehind = if (behind.nonEmpty) behind.max else 0

        val water          = Math.min(maxBefore, maxBehind) - currentTower
        val newAccumulator = if (water > 0) water + accumulator else accumulator

        helper(index + 1, newAccumulator)
      }
    }

    helper(0, 0)
  }
}
