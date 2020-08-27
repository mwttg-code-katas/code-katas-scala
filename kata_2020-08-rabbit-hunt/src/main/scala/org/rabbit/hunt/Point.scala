package org.rabbit.hunt

final case class Point(x: Int, y: Int)

final case class Line(from: Point, to: Point)

object Point {

  // alternative solution by Santo cross product of two vectors if area is 0 it's a line

  def isPointOnLine(line: Line, point: Point): Boolean = {
    if (line.from.x == line.to.x) {
      return line.from.x == point.x
    } else if (line.from.y == line.to.y && line.from.y == point.y) {
      return true
    }
    // f(x) = m * x + n
    val slope = (line.to.y - line.from.y) / (line.to.x - line.from.x)
    val n     = line.to.y - slope * line.to.x
    val y     = slope * point.x + n

    y == point.y
  }
}
