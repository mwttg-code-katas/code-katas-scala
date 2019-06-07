package org.landing.rover

object PlanetGridCreator {
  def createGrid(filename: String): List[List[SurfaceObject]] = {
    val lines    = FileReader.read(filename)
    val charGrid = createCharGrid(lines)
    transform(charGrid)
  }

  private val createCharGrid: List[String] => List[List[Char]] = lines => lines.map(l => l.toList)

  private lazy val transform: List[List[Char]] => List[List[SurfaceObject]] = charGrid =>
    charGrid.map(row => row.map(c => createSurfaceObject(c)))

  private val createSurfaceObject: Char => SurfaceObject = {
    case 'x' => Obstacle
    case '.' => Clearance
    case _ => Unknown
  }
}
