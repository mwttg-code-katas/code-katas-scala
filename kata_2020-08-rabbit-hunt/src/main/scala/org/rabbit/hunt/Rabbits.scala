package org.rabbit.hunt

import scala.io.Source

final case class Rabbits(amount: Int, positions: Set[Point])

object Rabbits {

  def initialize(filename: String): Rabbits = {
    val lines  = Source.fromResource(filename).getLines().toSeq
    val amount = lines.head.toInt
    val positions = lines.tail.map(line => {
      val coordinates = line.split(" ")
      Point(coordinates(0).toInt, coordinates(1).toInt)
    })

    Rabbits(amount, positions.toSet)
  }
}
