package org.roman.numerals

object Application {
  def main(args: Array[String]): Unit = {
    println(showResult(4))
    println(showResult(8))
    println(showResult(24))
    println(showResult(31))
    println(showResult(369))
    println(showResult(448))
    println(showResult(1995))
    println(showResult(2020))
  }

  private def showResult(number: Int): String = {
    val roman = RomanTransformer.toRoman(number)
    val newNumber = RomanTransformer.toNumber(roman)
    s"The following number '$number' is transformed to '$roman' and transformed back to '$newNumber'."
  }
}
