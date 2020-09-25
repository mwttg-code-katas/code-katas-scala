package org.game.of.pig

object Application {
  val Player1 = "Donald"
  val Player2 = "Alexis"
  val MaxScore = 20

  def main(args: Array[String]): Unit = {
    val players = Game.initialize(Player1, Player2)
    val gameLog = Game.mainLoop(players, MaxScore)
    gameLog.foreach(line => println(line))
  }
}
