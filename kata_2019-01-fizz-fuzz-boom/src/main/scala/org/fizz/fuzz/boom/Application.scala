package org.fizz.fuzz.boom

object Application extends App {
  FizzFuzzBoom(100).run()
  println("-----------------------")
  FizzFuzzBoom2(100).run()
  println("-----------------------")
  FizzFuzzBoomFp(100).run()
}
