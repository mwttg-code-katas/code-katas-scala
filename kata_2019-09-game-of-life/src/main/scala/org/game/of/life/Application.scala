package org.game.of.life

import scala.annotation.tailrec

/**
  * Interesting files:
  *  - pentomino.txt                    TargetGeneration = 1120
  *  - glider-2.txt                     TargetGeneration = 120
  *  - symmetrical.txt                  TargetGeneration = 55
  *  - heavy-weight-spaceships.txt      TargetGeneration = 1000
  *  - symmetrical-2.txt                TargetGeneration = 300
  *
  * Best visualization on sbt (terminal):
  *   - sbt
  *   - project kata_2019-09-game-of-life
  *   - runMain org.game.of.life.Application
  */
object Application {
  private val TargetGeneration = 120
  private val Filename         = "glider-2.txt"

  def main(args: Array[String]): Unit = {
    val lines          = Utils.readFile(Filename)
    val worldSize      = Utils.getWorldSize(lines)
    val generationZero = Population(lines, worldSize)
    loop(TargetGeneration, generationZero, Utils.printWorld)
  }

  @tailrec
  def loop(iteration: Int, population: Population, printFunc: (Population, Int) => Unit): Population =
    if (iteration == 0) {
      printFunc(population, TargetGeneration)
      population
    } else {
      printFunc(population, TargetGeneration)
      loop(iteration - 1, population.next(), printFunc)
    }
}
