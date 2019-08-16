package org.prime

import scala.annotation.tailrec

object IntExtension {

  def isPrime(number: Int): Boolean = {
    @tailrec
    def helper(currentDivisor: Int, accumulator: Boolean): Boolean =
      currentDivisor match {
        case 1 => accumulator
        case x => helper(x - 1, accumulator && number % currentDivisor != 0)
      }
    helper(number - 1, true)
  }

  def primeFactors(number: Int): Map[Int, Int] = {
    @tailrec
    def helper(primes: List[Int], restNumber: Int, accumulator: List[Int]): List[Int] =
      primes match {
        case Nil => accumulator
        case head :: tail =>
          if (restNumber % head == 0) {
            val newAccumulator = accumulator :+ head
            val newRestNumber  = restNumber - (restNumber / head)
            helper(primes, newRestNumber, newAccumulator)
          } else {
            helper(tail, restNumber, accumulator)
          }
      }

    val allPrimes = allPrimesSmaller(number)
    val result    = helper(allPrimes, number, List.empty)
    result.groupBy(x => identity(x)).map(tuple => (tuple._1, tuple._2.size))
  }

  def goldbach(number: Int): (Int, Int) = {
    require(number % 2 == 0, "Only even numbers!")

    @tailrec
    def helper(primes: List[Int], result: Option[(Int, Int)]): Option[(Int, Int)] =
      (primes, result) match {
        case (Nil, _) => None
        case (_, Some(r)) => Some(r)
        case (head :: tail, _) =>
          val rest = number - head
          if (isPrime(rest)) {
            val newPrimes = tail.filter(n => n != rest)
            val result    = Some((head, rest))
            helper(newPrimes, result)
          } else {
            helper(tail, None)
          }
      }

    val allPrimes = allPrimesSmaller(number).reverse
    helper(allPrimes, None) match {
      case Some(result) => result
      case None => throw new RuntimeException("Goldbach wasn't right.")
    }
  }

  private def allPrimesSmaller(n: Int) =
    (2 to n).filter(number => IntExtension.isPrime(number)).toList
}
