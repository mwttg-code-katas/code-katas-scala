package org.abc.blocks

import scala.annotation.tailrec

object CanMakeWord {

  def canMakeWord(word: String, blocks: List[Block]): Boolean = {
    @tailrec
    def helper(remainingLetters: Array[Char], remainingBlocks: List[Block], accumulator: Boolean): Boolean =
      if (remainingLetters.isEmpty) {
        accumulator
      } else {
        val letter               = remainingLetters.head
        val wasLetterFoundResult = checkBlocks(letter, remainingBlocks)

        val newRemainingLetters = remainingLetters.drop(1)
        val newRemainingBlocks  = wasLetterFoundResult.remainingBlocks
        val newAccumulator      = accumulator && wasLetterFoundResult.letterWasFound

        helper(
          newRemainingLetters,
          newRemainingBlocks,
          newAccumulator
        )
      }

    val letters = wordToLetters(word)
    helper(letters, blocks, true)
  }

  final case class BlockResult(letterWasFound: Boolean, remainingBlocks: List[Block])

  private def checkBlocks(letter: Char, blocks: List[Block]) = {
    @tailrec
    def helper(blocksToCheck: List[Block], accumulator: BlockResult): BlockResult =
      if (blocksToCheck.isEmpty) {
        accumulator
      } else {
        val block       = blocksToCheck.head
        val foundLetter = block.hasLetter(letter)

        // Remove the Block from the result?
        val newFound = foundLetter || accumulator.letterWasFound
        val newAccumulator = if (foundLetter && !accumulator.letterWasFound) {
          BlockResult(newFound, accumulator.remainingBlocks)
        } else {
          BlockResult(newFound, accumulator.remainingBlocks :+ block)
        }

        val remainingBlocksToCheck = blocksToCheck.drop(1)

        helper(remainingBlocksToCheck, newAccumulator)
      }

    helper(blocks, BlockResult(false, List.empty))
  }

  private def wordToLetters(word: String) = word.toCharArray
}
