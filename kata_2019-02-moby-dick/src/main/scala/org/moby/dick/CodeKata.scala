package org.moby.dick

object CodeKata extends App {
  val filename = "mobydick.txt"
  MobyDick.run1(filename)

  val result = MobyDick.run2(filename)
  println(result)
}
