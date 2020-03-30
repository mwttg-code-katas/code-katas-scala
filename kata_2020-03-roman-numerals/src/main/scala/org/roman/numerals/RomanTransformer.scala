package org.roman.numerals

import scala.annotation.tailrec

final case class LettersByBase(smaller: String, bigger: String)

final case class SumWithLastNumber(sum: Int, previousDigit: Int)

object RomanTransformer {

  val DigitToRoman = Map(
    1 -> LettersByBase("I", "V"),
    10 -> LettersByBase("X", "L"),
    100 -> LettersByBase("C", "D"),
    1000 -> LettersByBase("M", "-")
  )

  val RomanToDigit = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  def toRoman(number: Int): String = {
    @tailrec
    def helper(restNumber: Int, accumulator: String): String =
      if (restNumber == 0) {
        accumulator
      } else {
        val base           = Math.pow(10, Math.floor(Math.log10(restNumber))).toInt
        val digit          = restNumber / base
        val roman          = digitToRoman(digit, base)
        val newAccumulator = accumulator + roman
        val newRestNumber  = restNumber - (base * digit)
        helper(newRestNumber, newAccumulator)
      }

    helper(number, "")
  }

  private def digitToRoman(digit: Int, base: Int): String =
    digit match {
      case 1 => DigitToRoman(base).smaller
      case 2 => DigitToRoman(base).smaller * 2
      case 3 => DigitToRoman(base).smaller * 3
      case 4 => DigitToRoman(base).smaller + DigitToRoman(base).bigger
      case 5 => DigitToRoman(base).bigger
      case 6 => DigitToRoman(base).bigger + DigitToRoman(base).smaller
      case 7 => DigitToRoman(base).bigger + DigitToRoman(base).smaller * 2
      case 8 => DigitToRoman(base).bigger + DigitToRoman(base).smaller * 3
      case 9 => DigitToRoman(base).smaller + DigitToRoman(base * 10).smaller
      case 0 => DigitToRoman(base * 10).smaller
    }

  def toNumber(roman: String): Int = {
    val result = roman.foldLeft(SumWithLastNumber(0, 0)) { (accumulator, romanDigit) =>
      {
        val previousDigit = accumulator.previousDigit
        val currentDigit  = RomanToDigit(romanDigit)
        val actualSum     = accumulator.sum
        val newSum = if (currentDigit > previousDigit) {
          val modifiedSum = actualSum - previousDigit
          modifiedSum + (currentDigit - previousDigit)
        } else {
          actualSum + currentDigit
        }
        SumWithLastNumber(newSum, currentDigit)
      }
    }
    result.sum
  }
}
