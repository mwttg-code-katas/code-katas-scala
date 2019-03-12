package org.berlin.clock

import org.scalatest.{ Matchers, WordSpec }

class BerlinClockTest extends WordSpec with Matchers {
  // Here are some tests I used during development, I lost the tdd approach during the process :/
  "BerlinClock" should {
    val MaxHourSegments   = MaxSegments(4, 4)
    val MaxMinuteSegments = MaxSegments(11, 4)

    "generate Time class from String" in {
      val time   = "23:55:59"
      val actual = BerlinClock.createTimeFrom(time)
      actual shouldBe Time(23, 55, 59)
    }
    "generate the hour lamps - 03:00:00" in {
      val time   = Time(3, 0, 0)
      val actual = BerlinClock.getHour(time, MaxHourSegments)
      actual shouldBe "OOOO\nRRRO"
    }
    "generate the hour lamps - 07:00:00" in {
      val time   = Time(7, 0, 0)
      val actual = BerlinClock.getHour(time, MaxHourSegments)
      actual shouldBe "ROOO\nRROO"
    }
    "generate the hour lamps - 11:00:00" in {
      val time   = Time(11, 0, 0)
      val actual = BerlinClock.getHour(time, MaxHourSegments)
      actual shouldBe "RROO\nROOO"
    }
    "generate the hour lamps - 17:00:00" in {
      val time   = Time(17, 0, 0)
      val actual = BerlinClock.getHour(time, MaxHourSegments)
      actual shouldBe "RRRO\nRROO"
    }
    "generate the hour lamps - 21:00:00" in {
      val time   = Time(23, 0, 0)
      val actual = BerlinClock.getHour(time, MaxHourSegments)
      actual shouldBe "RRRR\nRRRO"
    }
    "generate the minute lamps - 00:34:00" in {
      val time   = Time(0, 34, 0)
      val actual = BerlinClock.getMinute(time, MaxMinuteSegments)
      actual shouldBe "YYYYYYOOOOO\nYYYY"
    }
    "alternating 2" in {
      val input  = "YYYYYYYYYYO"
      val actual = BerlinClock.replace(input)
      actual shouldBe "YYRYYRYYRYO"
    }
  }
}
