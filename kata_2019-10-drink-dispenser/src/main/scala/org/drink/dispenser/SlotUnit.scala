package org.drink.dispenser

class SlotUnit(var slots: Map[String, Int]) {
  def getDrink(name: String): Boolean =
    slots.get(name) match {
      case Some(value) =>
        if (value == 0) {
          println(s"Sorry but this sort of drink ('$name') is empty.")
          false
        } else {
          val newValue = value - 1
          slots += (name -> newValue)
          true
        }
      case None =>
        println(s"This drink ('$name') does not exists.")
        false
    }

  def fillSlots(refilled: Map[String, Int]): Unit = slots = refilled
}
