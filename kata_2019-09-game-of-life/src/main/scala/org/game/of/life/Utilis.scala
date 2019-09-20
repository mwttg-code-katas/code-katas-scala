package org.game.of.life

import scala.io.Source
import scala.util.{ Failure, Success, Try }

final case class WorldSize(width: Int, height: Int)

object Utils {
  private val DelayInMs = 50
  private val Alive     = '*'
  private val Dead      = '.'

  def readFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }

  def getWorldSize(lines: List[String]): WorldSize = {
    val height = lines.size
    val width  = lines.head.length
    WorldSize(width, height)
  }

  def printWorld(population: Population, targetGeneration: Int): Unit = {
    println(s"\n Generation ${population.generation} of $targetGeneration \n")
    Thread.sleep(DelayInMs)

    for (y <- 0 until population.size.height;
         x <- 0 until population.size.width) {
      val currentCell = Cell(x, y)

      if (population.livingCells.contains(currentCell)) {
        print(Alive)
      } else {
        print(Dead)
      }
      if (x == population.size.width - 1) {
        print("\n")
      }
    }
  }
}
