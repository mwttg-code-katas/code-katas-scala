import org.landing.rover._

object CodeKataApplication {
  def main(args: Array[String]): Unit = {
    val planet  = Planet("mars.txt")
    val rover   = LandingRover(PositionWithDirection(Position(30, 28), West))
    val mission = Mission("Mission On Mars")
    val result  = mission.start(planet, rover, "mars-mission-instructions.txt")
    println(result)
  }
}
