package org.berlin.clock

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Kata extends App {
  val now     = LocalDateTime.now()
  val pattern = DateTimeFormatter.ofPattern("HH:mm:ss")
  val time    = BerlinClock.getTime(now)
  println(time)
}
