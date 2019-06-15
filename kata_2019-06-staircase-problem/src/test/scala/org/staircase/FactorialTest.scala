package org.staircase

import org.scalatest.{ Matchers, WordSpec }

class FactorialTest extends WordSpec with Matchers {

  "FactorialTest" should {
    "calculate #fac(0)" in {
      Factorial.factorial(0) shouldBe 1
    }
    "calculate #fac(1)" in {
      Factorial.factorial(1) shouldBe 1
    }
    "calculate #fac(2)" in {
      Factorial.factorial(2) shouldBe 2
    }
    "calculate #fac(3)" in {
      Factorial.factorial(3) shouldBe 6
    }
    "calculate #fac(4)" in {
      Factorial.factorial(4) shouldBe 24
    }
    "calculate #fac(5)" in {
      Factorial.factorial(5) shouldBe 120
    }
    "calculate #fac(10)" in {
      Factorial.factorial(10) shouldBe 3628800
    }
  }
}
