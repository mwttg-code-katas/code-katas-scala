package org.game.of.pig

import scala.util.Random

sealed abstract class Move

case object Hold extends Move
case object Roll extends Move

object GameFunctions {

  private val Rnd = new Random

  def rollDice = 1 + Rnd.nextInt(6)

  def chooseMove = {
    1 + Rnd.nextInt(10) match {
      case x if x <= 4 => Hold
      case y if y > 4 => Roll
    }
  }
}
