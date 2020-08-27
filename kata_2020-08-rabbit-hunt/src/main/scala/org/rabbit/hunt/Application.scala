package org.rabbit.hunt

object Application {

  def main(args: Array[String]): Unit = {
    val filenames = List(
      "example1.txt",
      "example2.txt",
      "example3.txt",
      "example4.txt"
    )
    filenames.foreach(file => {
      val rabbits  = Rabbits.initialize(file)
      val solution = Solver.getMaxRabbitsInOneLine(rabbits)

      println(s"Solution for file '$file': $solution are max in one line")
    })
  }
}
