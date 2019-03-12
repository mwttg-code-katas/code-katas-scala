package org.berlin.clock

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Kata extends App {
  val pattern = DateTimeFormatter.ofPattern("HH:mm:ss")

  do {
    val now = LocalDateTime.now()
    println(s"--------${now.format(pattern)}---------------")
    println(BerlinClock.getTime(now))
    Thread.sleep(1000L)
  } while (true)
}
