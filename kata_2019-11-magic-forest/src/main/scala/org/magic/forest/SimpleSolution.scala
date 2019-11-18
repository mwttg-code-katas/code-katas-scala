package org.magic.forest

import scala.annotation.tailrec

object SimpleSolution {
  def solve(start: Population): Set[Population] = {
    @tailrec
    def helper(level: Int, currentPopulation: Set[Population]): Set[Population] = {
      println(s"new iteration $level  -  current items ${currentPopulation.size}")

      val filtered = currentPopulation.filter {
        case Population(0, _, 0) => true
        case Population(_, 0, 0) => true
        case Population(0, 0, _) => true
        case _ => false
      }

      if (filtered.nonEmpty) {
        filtered
      } else {
        val newPopulation = currentPopulation.foldLeft(Set.empty[Population]) { (accumulator, population) =>
          {
            val l = Population.wolfEatsGoat(population)
            val m = Population.lionEatsWolf(population)
            val r = Population.lionEatsGoat(population)
            Set(l, m, r).flatten ++ accumulator
          }
        }
        helper(level + 1, newPopulation)
      }
    }

    helper(1, Set(start))
  }
}
