package org.moby.dick

import scala.collection.immutable.ListMap
import scala.io.Source
import scala.util.{ Failure, Success, Try }

object MobyDick {

  def run2(filename: String) =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) =>
        ListMap(
          lines
            .flatMap(_.split("(\\.|,|'|\\?|\\!|\\s+)").filterNot(word => word == "").map(word => word.toLowerCase).toList)
            .groupBy(identity)
            .mapValues(_.size)
            .toSeq
            .sortWith(_._2 > _._2): _*
        )
      case Failure(exception) => throw new RuntimeException(s"Filename '$filename' not found or broke. Cause: $exception")
    }

  def run1(filename: String) = {
    val lines       = allLines(filename)
    val words       = allWords(lines)
    val table       = createTable(words)
    val sortedTable = sortTable(table)
    println(sortedTable)
  }

  def sortTable(table: Map[String, Int]): ListMap[String, Int] = ListMap(table.toSeq.sortWith(_._2 > _._2): _*)

  def createTable(words: List[String]): Map[String, Int] =
    words.groupBy(identity).mapValues(_.size)

  def allWords(lines: List[String]): List[String] =
    lines.flatMap(_.split("(\\.|,|'|\\?|\\!|\\s+)").filterNot(word => word == "").map(word => word.toLowerCase).toList)

  def allLines(filename: String): List[String] =
    readFile(filename) match {
      case Success(lines) => allWords(lines)
      case Failure(exception) => throw new RuntimeException(s"Filename '$filename' not found or broke. Cause: $exception")
    }

  def readFile(filename: String) =
    Try(Source.fromResource(filename).getLines().toList)
}
