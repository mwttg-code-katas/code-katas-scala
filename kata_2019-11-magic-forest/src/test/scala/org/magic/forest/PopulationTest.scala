package org.magic.forest

import org.scalatest.{ Matchers, WordSpec }

class PopulationTest extends WordSpec with Matchers {
  "Population" should {
    "be able to: a wolf eats a goat" in {
      val input = Population(goats = 1, wolves = 1, lions = 0)
      val actual = Population.wolfEatsGoat(input)
      actual shouldBe Some(Population(goats = 0, wolves = 0, lions = 1))
    }
    "NOT be able to: a wolf eats a goat - if no goat exists" in {
      val input = Population(goats = 0, wolves = 1, lions = 0)
      val actual = Population.wolfEatsGoat(input)
      actual shouldBe None
    }
    "NOT be able to: a wolf eats a goat - if no wolf exists" in {
      val input = Population(goats = 1, wolves = 0, lions = 0)
      val actual = Population.wolfEatsGoat(input)
      actual shouldBe None
    }
    "be able to: a lion eats a goat" in {
      val input = Population(goats = 1, wolves = 0, lions = 1)
      val actual = Population.lionEatsGoat(input)
      actual shouldBe Some(Population(goats = 0, wolves = 1, lions = 0))
    }
    "NOT be able to: a lion eats a goat - if no goat exists" in {
      val input = Population(goats = 0, wolves = 0, lions = 1)
      val actual = Population.lionEatsGoat(input)
      actual shouldBe None
    }
    "NOT be able to: a lion eats a goat - if no lion exists" in {
      val input = Population(goats = 1, wolves = 0, lions = 0)
      val actual = Population.lionEatsGoat(input)
      actual shouldBe None
    }
    "be able to: a lion eats a wolf" in {
      val input = Population(goats = 0, wolves = 1, lions = 1)
      val actual = Population.lionEatsWolf(input)
      actual shouldBe Some(Population(goats = 1, wolves = 0, lions = 0))
    }
    "NOT be able to: a lion eats a wolf - if no wolf exists" in {
      val input = Population(goats = 0, wolves = 0, lions = 1)
      val actual = Population.lionEatsWolf(input)
      actual shouldBe None
    }
    "NOT be able to: a lion eats a wolf - if no lion exists" in {
      val input = Population(goats = 0, wolves = 1, lions = 0)
      val actual = Population.lionEatsWolf(input)
      actual shouldBe None
    }
  }
}
