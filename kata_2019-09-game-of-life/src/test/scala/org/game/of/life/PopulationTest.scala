package org.game.of.life

import org.scalatest.{ Matchers, WordSpec }

class PopulationTest extends WordSpec with Matchers {
  "World" should {
    "initialize generation zero (no cell alive)" in {
      val worldSize = WorldSize(5, 3)
      val lines     = List(".....", ".....", ".....")

      Population(lines, worldSize) shouldBe
      Population(
        livingCells = Set.empty[Cell],
        generation  = 0,
        size        = worldSize
      )
    }
    "initialize generation zero (one cell alive)" in {
      val worldSize = WorldSize(5, 3)
      val lines     = List(".....", "..*..", ".....")

      Population(lines, worldSize) shouldBe
      Population(
        livingCells = Set(Cell(2, 1)),
        generation  = 0,
        size        = worldSize
      )
    }
    "initialize generation zero (one other cell alive)" in {
      val worldSize = WorldSize(5, 3)
      val lines     = List(".....", ".....", "...*.")

      Population(lines, worldSize) shouldBe
      Population(
        livingCells = Set(Cell(3, 2)),
        generation  = 0,
        size        = worldSize
      )
    }
    "initialize generation zero (three cells alive)" in {
      val worldSize = WorldSize(5, 3)
      val lines     = List(".*...", ".....", ".*.*.")

      Population(lines, worldSize) shouldBe
      Population(
        livingCells = Set(Cell(1, 0), Cell(1, 2), Cell(3, 2)),
        generation  = 0,
        size        = worldSize
      )
    }
    "generate the next generation (dying rule: living neighbour cells < 2)" in {
      val worldSize   = WorldSize(5, 5)
      val livingCells = Set(Cell(1, 1), Cell(2, 1))
      val population  = Population(livingCells, 0, worldSize)

      population.next() shouldBe
      Population(
        livingCells = Set.empty[Cell],
        generation  = 1,
        size        = worldSize
      )
    }
    "generate the next generation (birth rule: living neighbour cells = 3)" in {
      val worldSize = WorldSize(5, 5)
      val livingCells = Set(
        Cell(1, 2),
        Cell(2, 2),
        Cell(3, 2)
      )
      val population = Population(livingCells, 0, worldSize)

      population.next() shouldBe
      Population(
        livingCells = Set(
          Cell(2, 1),
          Cell(2, 2),
          Cell(2, 3)
        ),
        generation = 1,
        size       = worldSize
      )
    }
    "generate the next generation (nothing happens rule: living neighbour cells = 3 || 2)" in {
      val worldSize = WorldSize(5, 5)
      val livingCells = Set(
        Cell(1, 2),
        Cell(2, 2),
        Cell(1, 3),
        Cell(2, 3)
      )
      val population = Population(livingCells, 0, worldSize)

      population.next() shouldBe
      Population(
        livingCells = Set(
          Cell(1, 2),
          Cell(2, 2),
          Cell(1, 3),
          Cell(2, 3)
        ),
        generation = 1,
        size       = worldSize
      )
    }
  }
}
