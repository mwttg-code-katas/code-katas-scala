package org.scanner

object Application extends App {
  val filename = "all-numbers.txt"
  val result   = Scanner().read(filename)
  println(result)
}
