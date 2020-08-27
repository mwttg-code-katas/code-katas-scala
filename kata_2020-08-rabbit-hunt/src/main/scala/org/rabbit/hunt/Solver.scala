package org.rabbit.hunt

import scala.annotation.tailrec

object Solver {

  def getMaxRabbitsInOneLine(rabbits: Rabbits): Int = {
    @tailrec
    def helper(leftRabbits: Set[Point], rabbit: Point, accumulator: Set[Int]): Set[Int] =
      if (leftRabbits.isEmpty || leftRabbits.size == 1) {
        accumulator
      } else {
        val otherRabbit    = leftRabbits.head
        val line           = Line(rabbit, otherRabbit)
        val newLeftRabbits = leftRabbits.tail
        val inOneLine      = isRabbitOnLine(leftRabbits.diff(Set(rabbit, otherRabbit)), line, 2) // 2 because 2 rabbits are the line i

        helper(newLeftRabbits, rabbit, accumulator + inOneLine)
      }

    @tailrec
    def isRabbitOnLine(leftRabbits: Set[Point], line: Line, accumulator: Int): Int =
      if (leftRabbits.isEmpty) {
        accumulator
      } else {
        val rabbit   = leftRabbits.head
        val isOnLine = Point.isPointOnLine(line, rabbit)

        if (isOnLine) {
          isRabbitOnLine(leftRabbits.tail, line, accumulator + 1)
        } else {
          isRabbitOnLine(leftRabbits.tail, line, accumulator)
        }
      }

    rabbits.positions
      .flatMap(
        rabbit =>
          helper(
            rabbits.positions.diff(Set(rabbit)),
            rabbit,
            Set.empty
        )
      )
      .max
  }
}
