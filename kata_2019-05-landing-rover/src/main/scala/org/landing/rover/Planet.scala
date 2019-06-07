package org.landing.rover

final case class Planet(filename: String) {
  private val grid: Seq[Seq[SurfaceObject]] = PlanetGridCreator.createGrid(filename)

  require(
    isSquare(grid),
    "This Planet is not a sphere (no square grid)"
  )

  val maxX: Int = getLength(grid)

  val maxY: Int = getLength(grid)

  // TODO unfortunately up-side-down x vs y
  def getSurface(position: Position): SurfaceObject =
    grid(position.y)(position.x)

  private def getLength(grid: Seq[Seq[SurfaceObject]]) = grid.size - 1

  private def isSquare(grid: Seq[Seq[SurfaceObject]]) = {
    val size          = grid.size
    val sizeOfEachRow = grid.map(r => r.size)
    val allRowsEqSize = sizeOfEachRow.map(r => r == size)
    allRowsEqSize.foldLeft(true)(_ && _) // all true?
  }
}
