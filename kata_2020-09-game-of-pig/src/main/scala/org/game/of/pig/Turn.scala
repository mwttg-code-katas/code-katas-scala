package org.game.of.pig

import scala.annotation.tailrec

final case class TurnLog(content: List[String])

object Turn {

  def execute(): (Int, List[String]) = {
    @tailrec
    def helper(currentScore: Int, decision: Move, totalScore: Int, log: List[String]): (Int, List[String]) = {
      if (currentScore == 1) {
        val newLog = log :+ "  * decide to ROLL" :+ "    * dice shows '1'" :+ "  * this ends the turn"
        return (0, newLog)
      }
      val newTotalScore = totalScore + currentScore
      if (decision == Hold) {
        val newLog = log :+
          "  * decide to ROLL" :+  // from previous move
          s"    * dice shows '$currentScore'" :+  // from previous move
          "  * decide to HOLD" :+
          "  * this ends the turn"
        return (newTotalScore, newLog)
      }

      val newLog = log :+ "  * decide to ROLL" :+ s"    * dice shows '$currentScore'"
      helper(GameFunctions.rollDice, GameFunctions.chooseMove, newTotalScore, newLog)
    }
    val first = GameFunctions.rollDice
//    val log = List(s"  * dice shows '$first'")
    helper(first, Roll, 0, List.empty)
  }
}
