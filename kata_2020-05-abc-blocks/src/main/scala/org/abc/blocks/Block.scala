package org.abc.blocks

import scala.io.Source
import scala.util.{ Failure, Success, Try }

final case class Block(front: Char, back: Char) {

  def hasLetter(letter: Char): Boolean = (letter == front) || (letter == back)
}

object Block {

  def getBlocks(filename: String): List[Block] = {
    val lines = readTextFile(filename)
    createBlocks(lines)
  }

  private def createBlocks(lines: List[String]) =
    lines.map(line => {
      val splitLine = line.split(" ")
      Block(splitLine(0).charAt(0), splitLine(1).charAt(0))
    })

  private def readTextFile(filename: String): List[String] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) => lines
      case Failure(_) => List.empty
    }
}
