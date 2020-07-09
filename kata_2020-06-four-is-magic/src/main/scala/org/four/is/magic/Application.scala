package org.four.is.magic

object Application {


  def main(args: Array[String]): Unit = {
    println(FourIsMagic.conjure(1))
    println(FourIsMagic.conjure(2))
    println(FourIsMagic.conjure(3))
    println(FourIsMagic.conjure(4))
    println(FourIsMagic.conjure(5))
    println(FourIsMagic.conjure(6))
    println(FourIsMagic.conjure(7))
    println(FourIsMagic.conjure(8))
    println(FourIsMagic.conjure(9))
    println(FourIsMagic.conjure(123456789153L))
  }
}
