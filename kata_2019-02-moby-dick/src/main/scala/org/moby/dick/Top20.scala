// javish
package org.moby.dick

import scala.collection.immutable.ListMap
import scala.io.Source
import scala.util.{ Failure, Success, Try }

object Top20 {
  private val pattern = "(\\.|,|'|\\?|\\!|\\s+)"

  def get(filename: String): ListMap[String, Int] = {
    val lines       = allLines(filename)
    val words       = allWords(lines)
    val table       = createTable(words)
    val sortedTable = sortTable(table)
    sortedTable.take(20)
  }

  def sortTable(table: Map[String, Int]): ListMap[String, Int] = ListMap(table.toSeq.sortWith(_._2 > _._2): _*)

  def createTable(words: List[String]): Map[String, Int] =
    words.groupBy(identity).mapValues(_.size)

  def allWords(lines: List[String]): List[String] =
    lines.flatMap(_.split(pattern).filterNot(word => word == "").map(word => word.toLowerCase).toList)

  def allLines(filename: String): List[String] =
    readFile(filename) match {
      case Success(lines) => allWords(lines)
      case Failure(exception) => throw new RuntimeException(s"Filename '$filename' not found or broken. Cause: $exception")
    }

  def readFile(filename: String) =
    Try(Source.fromResource(filename).getLines().toList)
}
