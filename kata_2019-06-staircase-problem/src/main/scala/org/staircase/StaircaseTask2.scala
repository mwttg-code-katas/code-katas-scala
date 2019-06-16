package org.staircase

import scala.annotation.tailrec

object StaircaseTask2 {
  // https://stackoverflow.com/questions/29665251/find-combinations-in-scala-list-of-lists
  def combs[Int](xss: List[List[Int]]): List[List[Int]] = xss match {
    case Nil => List(Nil)
    case xs :: rss => for (x <- xs; cs <- combs(rss)) yield x :: cs
  }

  /*
     Because I couldn't tell the computer how to decompose the sum how I do it on paper
     I create all possibilities for each summand (from zero to max(summand) = sum / summand )
     and filter after that, which combinations fulfill the formula so that the result = sum
   */
  def decomposeSum(sum: Int, summands: List[Int]): List[List[Int]] = {
    val maxValueForEachSummands          = summands.map(summand => sum / summand)
    val possibleValueForEachSummand      = for (maxSummand <- maxValueForEachSummands) yield (maxSummand to 0 by -1).toList
    val allCombinations: List[List[Int]] = combs(possibleValueForEachSummand)

    allCombinations.filter(xs => {
      val listOfAmountOfSummands = xs
      val listOfValueOfSummands  = summands
      val zip                    = listOfAmountOfSummands.zip(listOfValueOfSummands)
      val products               = zip.map(item => item._1 * item._2)
      products.sum
    } == sum)
  }

  def numWays(stairs: Int, steps: List[Int]): (Int, List[List[Int]]) = {
    val orderedSteps             = steps.sorted
    val usefulReverseSortedSteps = orderedSteps.filter(n => n <= stairs).reverse

    val allFormulas = decomposeSum(stairs, usefulReverseSortedSteps)

    @tailrec
    def helper(listOfSteps: List[List[Int]], accumulator: (Int, List[List[Int]])): (Int, List[List[Int]]) =
      listOfSteps match {
        case Nil => accumulator
        case head :: tail =>
          val steps           = createSteps(usefulReverseSortedSteps, head)
          val ways            = steps.permutations.toList
          val newNumberOfWays = accumulator._1 + ways.size
          val newWays         = accumulator._2 ::: ways
          helper(tail, (newNumberOfWays, newWays))
      }

    helper(allFormulas, (0, List.empty))
  }

  /*
    After I know how many summands of each summand I need, it's time to create a list with
    all theses summands, so I can create the permutations of it
   */
  def createSteps(sortedSummands: List[Int], amountOfSummands: List[Int]): List[Int] = {
    val zip = sortedSummands.zip(amountOfSummands)
    zip.flatMap(item => {
      List.fill(item._2)(item._1)
    })
  }
}
