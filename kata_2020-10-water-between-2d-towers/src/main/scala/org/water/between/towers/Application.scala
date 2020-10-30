package org.water.between.towers

object Application {
  def main(args: Array[String]): Unit = {

    val worlds = List(
      List(1, 5, 3, 7, 2),
      List(5, 3, 7, 2, 6, 4, 5, 9, 1, 2),
      List(2, 6, 3, 5, 2, 8, 1, 4, 2, 2, 5, 3, 5, 7, 4, 1),
      List(5, 5, 5, 5),
      List(5, 6, 7, 8),
      List(8, 7, 7, 6),
      List(6, 7, 10, 7, 6)
    )
    worlds
      .map(towers => Water.getAmount(towers))
      .foreach(water => println(water))
  }
}
