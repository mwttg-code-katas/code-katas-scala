package org.four.is.magic

object NumberToWord {

  def convert(number: Long): String = {
    val threeDigitGroups = ExtractThreeDigitGroups.from(number)
    val threeDigitGroupsAsWords = threeDigitGroups.map(ConvertThreeDigitGroup.toWord)
    RecombineThreeDigitWordGroups.combine(threeDigitGroupsAsWords)
  }
}
