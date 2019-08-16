package org.prime

object Application {
  def main(args: Array[String]): Unit = {
    println((2 to 20).map(number => (number, IntExtension.isPrime(number))))

    println(IntExtension.primeFactors(315))

    println(IntExtension.goldbach(28))
  }
}
