package org.fizz.fuzz.boom

import scala.collection.immutable.HashMap
import scala.util.control.Breaks._

class FizzFuzzBoom2(max: Int) {

  val f: Int => Boolean = (x: Int) => x % 3 == 0
  val g: Int => Boolean = (x: Int) => x % 5 == 0
  val h: Int => Boolean = (x: Int) => x % 3 == 0 && x % 5 == 0

  def run(): Unit = {

    val divisors = HashMap(h -> "boom", f -> "fizz", g -> "fuzz")

    // Does not work if more than one function does apply
    for (index <- 0 until max) {
      breakable {
        for (div <- divisors) {
          if (div._1(index)) {
            println(div._2)
          } else {
            println(index)
            break
          }

        }
      }
    }
  }
}

object FizzFuzzBoom2 {
  def apply(max: Int): FizzFuzzBoom2 = new FizzFuzzBoom2(max)
}
