package org.scanner

object Application extends App {
  val filename = "all-numbers.txt"
  val result   = Scanner().read(filename)

  if (result.isDefined) {
    println(result.get)
  } else {
    println("No number available")
  }
}
