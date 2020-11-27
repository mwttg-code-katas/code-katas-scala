package org.stones.and.jewels

object FindJewels {

  // hint by Santo (before I had a foldLeft)
  def searchBetter(stones: String, jewels: String): Int = stones.count(stone => jewels.contains(stone))

}
