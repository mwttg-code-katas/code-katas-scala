package org.abc.blocks

object Application {

  def main(args: Array[String]): Unit  =  {
    val blocks = Block.getBlocks("blocks.txt")

    println(s"""can_make_word("A") --> ${CanMakeWord.canMakeWord("A", blocks)} should be true""")
    println(s"""can_make_word("BARK") --> ${CanMakeWord.canMakeWord("BARK", blocks)} should be true""")
    println(s"""can_make_word("BOOK") --> ${CanMakeWord.canMakeWord("BOOK", blocks)} should be false""")
    println(s"""can_make_word("TREAT") --> ${CanMakeWord.canMakeWord("TREAT", blocks)} should be true""")
    println(s"""can_make_word("COMMON") --> ${CanMakeWord.canMakeWord("COMMON", blocks)} should be false""")
    println(s"""can_make_word("SQUAD") --> ${CanMakeWord.canMakeWord("SQUAD", blocks)} should be true""")
    println(s"""can_make_word("CONFUSE") --> ${CanMakeWord.canMakeWord("CONFUSE", blocks)} should be true""")
  }
}
