package org.drink.dispenser

class Configuration {
  val SlotSize = 100

  val drinkConfiguration: Map[String, Int] =
    Map(
      "Water" -> 80,
      "Nuke Cola" -> 120,
      "Nuke Cola Quantum" -> 340,
      "Duff Beer" -> 230,
      "Booty Sweat" -> 250
    )
}
