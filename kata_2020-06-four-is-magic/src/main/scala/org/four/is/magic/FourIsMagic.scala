package org.four.is.magic

import scala.annotation.tailrec

object FourIsMagic {

  def conjure(number: Long): String = {
    @tailrec
    def helper(restNumber: Long, accumulator: String): String = {
      val numberAsText = NumberToWord.convert(restNumber)
      val length = numberAsText.length
      val lengthAsText = NumberToWord.convert(length)

      if (length == 4) {
        return s"$accumulator$numberAsText is $lengthAsText, four is magic"
      }

      val part = s"$numberAsText is $lengthAsText, "
      helper(length, accumulator + part)
    }

    helper(number, "")
  }
}
