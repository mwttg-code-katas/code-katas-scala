package org.word.puzzle

import org.word.puzzle.task1.Palindrome
import org.word.puzzle.task2.Anagram
import org.word.puzzle.task3.WordList

object WordPuzzleKata extends App {
  println("----- Task 1 -----")
  val ReliefPfeiler = "Reliefpfeiler"
  println(s"Is '$ReliefPfeiler' (${ReliefPfeiler.length}) a palindrome? ${Palindrome.check(ReliefPfeiler)}")

  println("----- Task 2 -----")
  val Leben = "Leben"
  val Nebel = "Nebel"
  println(s"Is '$Leben' an anagram of '$Nebel'? ${Anagram.check2(Leben, Nebel)}")

  println("----- Task 3 -----")
  val words  = WordList.readFile("word-list.txt").get
  val start  = System.currentTimeMillis
  val result = WordList.getAnagrams(words)
  val stop   = System.currentTimeMillis()
  println(s"get all anagrams of the word-list took: ${stop - start} ms")
  println(s"The anagrams are: $result")
}
