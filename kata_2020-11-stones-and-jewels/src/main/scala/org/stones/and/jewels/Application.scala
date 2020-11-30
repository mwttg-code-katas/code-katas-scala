package org.stones.and.jewels

object Application {

  def main(args: Array[String]): Unit = {
    println(FindJewels.searchBetter("aAAbbbb", "aA"))
    println(FindJewels.searchBetter("ZZ", "z"))
  }
}
