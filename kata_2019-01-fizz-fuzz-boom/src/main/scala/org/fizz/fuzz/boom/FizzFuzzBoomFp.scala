package org.fizz.fuzz.boom
import scala.collection.immutable.ListMap

// Solution was presented by Marcel Jacob
class FizzFuzzBoomFp(max: Int) {
  val mod3: Int => Boolean     = (x: Int) => x % 3 == 0
  val mod5: Int => Boolean     = (x: Int) => x % 5 == 0
  val mod3And5: Int => Boolean = (x: Int) => x % 3 == 0 && x % 5 == 0

  val divisors
    : ListMap[Int => Boolean, String] = ListMap(mod3And5 -> "Boom", mod3 -> "Fizz", mod5 -> "Fuzz") // ListMap because of chronological order

  def run(): Unit =
    Stream
      .from(1)
      .take(max)
      .map(number => divisors.filter(item => item._1(number)).values.headOption.getOrElse(number.toString))
      .foreach(println)
}

object FizzFuzzBoomFp {
  def apply(max: Int): FizzFuzzBoomFp = new FizzFuzzBoomFp(max)
}
