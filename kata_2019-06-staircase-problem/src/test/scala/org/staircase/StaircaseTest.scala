package org.staircase

import org.scalatest.{ Matchers, WordSpec }

class StaircaseTest extends WordSpec with Matchers {
  "Staircase" should {
    "calculate combinations without iterations of placement of one's and two's" in {
      // 2x 2
      // 1x 1
      // 122, 212, 221
      Staircase.combinations(1, 2) shouldBe 3
    }
    "calculate another combinations without iterations of placement of one's and two's" in {
      // 3x 2
      // 1x 1
      // 1222, 2122, 2212, 2221
      Staircase.combinations(1, 3) shouldBe 4
    }
    "calculate yet another combinations without iterations of placement of one's and two's" in {
      // 3x 2
      // 2x 1
      // 11222, 12122, 12212, 12221
      // 21122, 21212, 21221
      // 22112, 22121
      // 22211
      Staircase.combinations(2, 3) shouldBe 10
    }
    "calculate the numWays of 7 stair staircase" in {
      Staircase.numWays(7) shouldBe 21
    }
  }

}
