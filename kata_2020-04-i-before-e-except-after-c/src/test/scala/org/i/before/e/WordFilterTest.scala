package org.i.before.e

import org.scalatest.{Matchers, WordSpec}

class WordFilterTest extends WordSpec with Matchers {

  // def words = List("ie", "believe", "fierce", "collie", "die", "friend", "ciemmmie", "mmmciemmmie", "ancient", "ei", "receive", "ceiling", "receipt", "ceilidh", "eimmmei", "mmmei", "ccmeimmmmc")

  def words  = List("ancient")

  "WordFilter" should {
    "filter i before e not preceded by c" in {
      val actual = WordFilter.filter(words)
      println(actual);
    }
  }
//    "filter i before e preceded by c" in {
//      val actual = WordFilter.filterNotIBeforeENotPrecededByC(ie)
//      actual should contain theSameElementsAs List("ciemmmie", "mmmciemmmie")
//    }
//
//    "filter e before i preceded by c" in {
//      val actual = WordFilter.filterEBeforeIPrecededByC(ei)
//      actual should contain theSameElementsAs List("receive", "ceiling", "receipt", "ceilidh")
//    }
//    "filter e before i not preceded by c" in {
//      val actual = WordFilter.filterNotEBeforeIPrecededByC(ei)
//      actual should contain theSameElementsAs List("ei", "eimmmei", "mmmei", "ccmeimmmmc")
//    }
//  }
}
