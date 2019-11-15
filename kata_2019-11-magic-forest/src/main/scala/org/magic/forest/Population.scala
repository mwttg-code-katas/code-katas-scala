package org.magic.forest

final case class Population(goats: Int, wolves: Int, lions: Int)

object Population {
  def wolfEatsGoat(population: Population): Option[Population] =
    if (population.goats == 0 || population.wolves == 0) {
      None
    } else {
      Some(
        Population(
          goats  = population.goats - 1,
          wolves = population.wolves - 1,
          lions  = population.lions + 1
        )
      )
    }

  def lionEatsGoat(population: Population): Option[Population] =
    if (population.goats == 0 || population.lions == 0) {
      None
    } else {
      Some(
        Population(
          goats  = population.goats - 1,
          wolves = population.wolves + 1,
          lions  = population.lions - 1
        )
      )
    }

  def lionEatsWolf(population: Population): Option[Population] =
    if (population.wolves == 0 || population.lions == 0) {
      None
    } else {
      Some(
        Population(
          goats  = population.goats + 1,
          wolves = population.wolves - 1,
          lions  = population.lions - 1
        )
      )
    }
}
