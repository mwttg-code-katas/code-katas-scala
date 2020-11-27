package org.stones.and.jewels

object Application {

  def main(args: Array[String]): Unit = {
    println(FindJewels.search("aAAbbbb", "aA"))
    println(FindJewels.search("ZZ", "z"))

    println(FindJewels.searchBetter("aAAbbbb", "aA"))
    println(FindJewels.searchBetter("ZZ", "z"))
  }
}
