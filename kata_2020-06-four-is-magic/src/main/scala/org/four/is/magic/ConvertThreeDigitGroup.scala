package org.four.is.magic

object ConvertThreeDigitGroup {

  def toWord(threeDigits: Int): String = {
    val hundredDigit = threeDigits / 100
    val tens     = threeDigits % 100
    val hundredsAsWord = createHundredsAsWord(hundredDigit)
    createTensAsWord(hundredsAsWord, tens)
  }

  private def createTensAsWord(hundredsAsWord: String, tensDigits: Int) = {
    val tens = tensDigits / 10
    val ones = tensDigits % 10

    val tensAsWord = (tens, ones) match {
      case (x, y) if x >= 2 && y != 0 => Tens(x) + " " + Small(y)
      case (x, y) if x >= 2 && y == 0 => Tens(x)
      case (x, _) if x < 2 => Small(tensDigits)
    }

    (tensAsWord, hundredsAsWord) match {
      case ("", _) => hundredsAsWord
      case (_, "") => tensAsWord
      case (_, _) => hundredsAsWord + " " + tensAsWord
    }
  }

  private def createHundredsAsWord(hundredDigit: Int): String = {
    if (hundredDigit == 0) {
      return ""
    }

    Small(hundredDigit) + " hundred"
  }

  private val Small = Map(
    0 -> "",
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen"
  )

  private val Tens = Map(
    2 -> "twenty",
    3 -> "thirty",
    4 -> "forty",
    5 -> "fifty",
    6 -> "sixty",
    7 -> "seventy",
    8 -> "eighty",
    9 -> "ninety"
  )
}
