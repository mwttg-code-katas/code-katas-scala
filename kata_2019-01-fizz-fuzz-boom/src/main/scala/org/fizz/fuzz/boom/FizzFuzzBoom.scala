package org.fizz.fuzz.boom

class FizzFuzzBoom(max: Int) {

  def run(): Unit =
    for (index <- 0 until max) {
      println(s"$index --- ${result(index)}")
    }

  def result(number: Int): String =
    number match {
      case x: Int if mod3(x) && mod5(x) => "boom"
      case x: Int if mod5(x) => "fuzz"
      case x: Int if mod3(x) => "fizz"
      case x: Int => x.toString
    }

  def mod3(x: Int): Boolean = x % 3 == 0

  def mod5(x: Int): Boolean = x % 5 == 0
}

object FizzFuzzBoom {
  def apply(max: Int): FizzFuzzBoom = new FizzFuzzBoom(max)
}
