# Prime Number Puzzles

## Task 1: Determine whether  a given integer number is prime
What is a prime number?

A prime number is a number > 1 that cannot formed by multiplying two smaller natural numbers. [Wikipedia](https://en.wikipedia.org/wiki/Prime_number)

Input:
* `isPrime(n: Int): Boolean` e.g. `isPrime(7)`
* alternative: `7.isPrime`

Output:
* `true` / `false`

## Task 2: Determine the prime factors of a given positive integer
What are prime factors?

Prime factors are a notation of a natural number n as product of (only) prime numbers. [Explanation](https://www.mathsisfun.com/prime-factorization.html)

Input:
* `primeFactors(n: Int): Int` e.g. `primeFactors(315)`
* alternative: `315.primeFactors`

Output:
* `List(3, 3, 5, 7)`

Bonus:
* `List((3, 2), (3, 1), (7, 1))`
* alternative: `Map(3 → 2, 5 → 1, 7 → 1)`

## Task 3 (Bonus): Determine a function to decompose a positive Integer > 2 with Goldbach's conjecture
What is the Goldbach conjecture?

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. E.g. 28 = 5 + 23. [Wikipedia](https://en.wikipedia.org/wiki/Goldbach%27s_conjecture)

Input:
* `golbach(n: Int): Int` e.g. `goldbach(28)`
* alternative: `28.golbach`

Output:
* `List(5, 23)`
* alternative: `(5, 23)`

## Source
[99 Scala Problems](http://aperiodic.net/phil/scala/s-99/)
* P31
* P35 + P36
* P40