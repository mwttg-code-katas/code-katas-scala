package org.moby.dick
import scala.collection.immutable.ListMap
import scala.io.Source
import scala.util.{ Failure, Success, Try }

object Top21 {
  private val pattern = "(\\.|,|'|\\?|\\!|\\s+)"

  def get(filename: String): ListMap[String, Int] =
    Try(Source.fromResource(filename).getLines().toList) match {
      case Success(lines) =>
        ListMap(
          lines
            .flatMap(_.split(pattern).filterNot(word => word == "").map(word => word.toLowerCase).toList)
            .groupBy(identity)
            .mapValues(_.size)
            .toSeq
            .sortWith(_._2 > _._2): _*
        ).take(21)
      case Failure(exception) => throw new RuntimeException(s"Filename '$filename' not found or broke. Cause: $exception")
    }
}
