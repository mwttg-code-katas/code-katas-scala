package org.drink.dispenser

import org.scalatest.{ Matchers, WordSpec }

class SlotUnitTest extends WordSpec with Matchers {

  "SlotUnit" should {
    val slots = Map("milk" -> 10, "water" -> 0)

    "getDrink if drink is available" in {
      val subject = new SlotUnit(slots)
      subject.getDrink("milk") shouldBe true
      subject.slots shouldBe Map("milk" -> 9, "water" -> 0)
    }

    "get NO drink if slot is empty" in {
      val subject = new SlotUnit(slots)
      subject.getDrink("water") shouldBe false
      subject.slots shouldBe Map("milk" -> 10, "water" -> 0)
    }

    "get NO drink if this sort of drink does not exists" in {
      val subject = new SlotUnit(slots)
      subject.getDrink("ThisDrinkDoesNotExist") shouldBe false
      subject.slots shouldBe Map("milk" -> 10, "water" -> 0)
    }

    "fill slots" in {
      val subject = new SlotUnit(slots)
      val refilled = Map("drink1" -> 100, "drink2" -> 50)
      subject.fillSlots(refilled)
      subject.slots shouldBe Map("drink1" -> 100, "drink2" -> 50)
    }
  }
}
