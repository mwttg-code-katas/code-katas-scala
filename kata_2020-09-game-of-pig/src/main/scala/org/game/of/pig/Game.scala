package org.game.of.pig

import scala.annotation.tailrec

final case class Player(name: String, score: Int)

object Game {

  def initialize(player1: String, player2: String): (Player, Player) = (Player(player1, 0), Player(player2, 0))

  def mainLoop(players: (Player, Player), maxScore: Int): List[String] = {
    @tailrec
    def helper(players: (Player, Player), log: List[String]): List[String] = {
      if (players._2.score >= maxScore) {
        val newLog = log :+
          s"!!Game Over!! - ${players._2.name} wins with ${players._2.score} points" :+
          s"  ${players._1.name} has ${players._1.score} points"
        return newLog
      }
      val turn = Turn.execute()
      val newLog = log :+
        s"${players._1.name}'s turn - current Points: ${players._1.score}" :++
          turn._2 :+
        s"${turn._1} points added to ${players._1.name}'s score - total score is now: ${players._1.score + turn._1}"
      val newPlayers = (Player(players._1.name, players._1.score + turn._1), players._2)
      helper(newPlayers.swap, newLog)
    }

    helper(players, List.empty[String])
  }
}
