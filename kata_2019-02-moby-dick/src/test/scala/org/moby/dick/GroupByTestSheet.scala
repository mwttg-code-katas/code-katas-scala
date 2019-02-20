package org.moby.dick
import org.scalatest.{ Matchers, WordSpec }

class GroupByTestSheet extends WordSpec with Matchers {
  "TestSheet for #groupBy" should {
    "group the elements by 'identity'" in {
      val input  = List("a", "aa", "a", "b", "c")
      val actual = input.groupBy(identity)
      println(actual)
      actual shouldBe Map(
        "c" -> List("c"),
        "b" -> List("b"),
        "aa" -> List("aa"),
        "a" -> List("a", "a")
      )
    }
    "groupBy 'identity' should be the same like 'x => x'" in {
      val input  = List("a", "aa", "a", "b", "c")
      val actual = input.groupBy(x => x)
      println(actual)
      actual shouldBe Map(
        "c" -> List("c"),
        "b" -> List("b"),
        "aa" -> List("aa"),
        "a" -> List("a", "a")
      )
    }
    "#mapValues" in {
      val input  = List("a", "aa", "a", "b", "c")
      val actual = input.groupBy(identity).mapValues(x => x.size)
      println(actual)
      actual shouldBe Map(
        "c" -> 1,
        "b" -> 1,
        "aa" -> 1,
        "a" -> 2
      )
    }
  }
}
