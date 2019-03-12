package org.berlin.clock
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

final case class Time(hour: Int, minute: Int, second: Int)

final case class MaxSegments(maxFirstRow: Int, maxSecondRow: Int)

object BerlinClock {

  private val HourFunc: Int => (Int, Int) = hour => {
    val firstRow  = hour / 5
    val secondRow = hour - (firstRow * 5)
    (firstRow, secondRow)
  }

  private[clock] val MinuteFunc: Int => (Int, Int) = minute => {
    val firstRow  = minute / 5
    val secondRow = minute - (firstRow * 5)
    (firstRow, secondRow)
  }

  private val MaxHourSegments = MaxSegments(4, 4)

  private val MaxMinuteSegments = MaxSegments(11, 4)

  private val Pattern = DateTimeFormatter.ofPattern("HH:mm:ss")

  def getTime(now: LocalDateTime): String = {
    val timeAsString = now.format(Pattern)
    val time         = createTimeFrom(timeAsString)
    val second       = getSecond(time)
    val hour         = getHour(time, MaxHourSegments)
    val minute       = getMinute(time, MaxMinuteSegments)
    second + "\n" + hour + "\n" + minute
  }

  private[clock] def createTimeFrom(time: String): Time = {
    val timeParts = time.split(":")
    Time(
      timeParts(0).toInt,
      timeParts(1).toInt,
      timeParts(2).toInt
    )
  }

  private[clock] def getHour(time: Time, maxSegments: MaxSegments): String =
    generateLamps(
      time.hour,
      HourFunc,
      MaxHourSegments,
      "R",
      replaceLamps = false
    )

  private[clock] def getMinute(time: Time, maxSegments: MaxSegments): String =
    generateLamps(
      time.minute,
      MinuteFunc,
      MaxMinuteSegments,
      "Y",
      replaceLamps = true
    )

  private[clock] def getSecond(time: Time): String = {
    val seconds = time.second
    if (seconds % 2 == 0) {
      "Y"
    } else {
      "O"
    }
  }

  private[clock] def generateLamps(timePart: Int,
                                   func: Int => (Int, Int),
                                   maxSegments: MaxSegments,
                                   light: String,
                                   replaceLamps: Boolean): String = {
    val result = func(timePart)
    val firstRow = generateRow(
      result._1,
      maxSegments.maxFirstRow,
      light,
      replaceLamps = false
    )
    val secondRow = generateRow(
      result._2,
      maxSegments.maxSecondRow,
      light,
      replaceLamps
    )

    firstRow + "\n" + secondRow
  }

  private[clock] def generateRow(segments: Int, maxSegments: Int, light: String, replaceLamps: Boolean): String = {
    val fillUp   = maxSegments - segments
    val lampsOn  = List.fill(segments)(light).mkString
    val lampsOff = List.fill(fillUp)("O").mkString

    val lamps = lampsOn + lampsOff
    if (replaceLamps) {
      replace(lamps)
    } else {
      lamps
    }
  }

//     uglyness from hell - not functional
//  def alternating(lamps: String): String = {
//    var index = -1
//    for (lamp <- lamps) yield {
//      index = index + 1
//      if (index != 0 && (index + 1) % 3 == 0 && lamp == 'Y') {
//        'R'
//      } else {
//        lamp
//      }
//    }
//  }

  private[clock] def replace(lamps: String): String =
    lamps.zipWithIndex.map {
      case (character, index) =>
        if (replaceable(character, index)) {
          'R'
        } else {
          character
        }
    }.mkString

  private[clock] def replaceable(character: Char, index: Int) =
    (index != 0) && ((index + 1) % 3 == 0) && (character == 'Y')
}
