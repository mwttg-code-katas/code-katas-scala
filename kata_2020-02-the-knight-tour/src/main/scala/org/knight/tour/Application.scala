package org.knight.tour

object Application {
  def main(args: Array[String]): Unit = {

    val dimension = 5 // 5 x 5 chessboard
    val startPosition = Position(2, 2)
    val startNode = Node(None, startPosition, Set(startPosition))

    val start  = System.currentTimeMillis()
    val result = Tour.knightTours(dimension, startNode)
    val end    = System.currentTimeMillis()

    println(s"calculating the result took ${end - start} ms.")
    println(s"for a knight on a $dimension x $dimension chessboard with start position ${startNode.position} exists ${result.amountOfTours} different tours.")
    println
    result.tours.foreach(item => {
      println(item)
      println()
    })
  }
}
