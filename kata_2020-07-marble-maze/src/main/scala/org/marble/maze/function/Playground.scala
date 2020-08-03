package org.marble.maze.function

import scala.io.Source

object Playground {

  def createFrom(filename: String): Seq[Seq[Boolean]] = {
    val content = from(filename)
    transform(content)
  }

  private def from(filename: String): Seq[String] = Source.fromResource(filename).getLines().toSeq

  private def transform(fileContent: Seq[String]): Seq[Seq[Boolean]] =
    fileContent.map(row => {
      row.map {
        case ' ' => true
        case _ => false // means wall
      }
    })
}
