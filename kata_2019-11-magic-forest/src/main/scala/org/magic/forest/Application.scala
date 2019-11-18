package org.magic.forest

object Application {
  def main(args: Array[String]): Unit = {
    val input = Population(17, 55, 6)
    val solution = SimpleSolution.solve(input)
    println("----------------------")
    println("A solution was found. Max number of animals, which can live in the Magic-Forest is:")
    println(s"goats ............ ${solution.head.goats}")
    println(s"wolves ........... ${solution.head.wolves}")
    println(s"lions  ........... ${solution.head.lions}")
  }
}
