package org.marble.maze.function

import scala.io.Source
import scala.util.Try

final case class Dimension(width: Int, height: Int)

final case class Playground(dimension: Dimension, tiles: Seq[Seq[Boolean]]) {
  def possibleWaysFrom(position: Position): Seq[Position] =
    getNeighboursOf(position)
      .filter(neighbour => neighbour.isDefined)
      .map(neighbour => neighbour.get)

  private def getNeighboursOf(position: Position) = {
    // not the nicest way :/
    val down  = Try(tiles(position.y + 1)(position.x)).toOption.map(_ => Position(position.y + 1, position.x))
    val left  = Try(tiles(position.y)(position.x - 1)).toOption.map(_ => Position(position.y, position.x - 1))
    val right = Try(tiles(position.y)(position.x + 1)).toOption.map(_ => Position(position.y, position.x + 1))
    Seq(down, left, right)
  }
}

object Playground {

  def createFrom(filename: String): Playground = {
    val content   = from(filename)
    val tiles     = transform(content)
    val dimension = Dimension(tiles.head.size, tiles.size)
    Playground(dimension, tiles);
  }

  private[function] def from(filename: String) = Source.fromResource(filename).getLines().toSeq

  private[function] def transform(fileContent: Seq[String]) =
    fileContent.map(row => {
      row.map {
        case ' ' => true
        case _ => false // means wall
      }
    })
}
