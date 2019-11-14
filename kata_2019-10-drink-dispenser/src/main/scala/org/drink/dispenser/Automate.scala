package org.drink.dispenser


final case class Coin(value: Int)

final case class Drink(name: String, price: Int)

final case class SlotInventory(price: Int, amount: Int)

class Automate(var slots: Map[String, SlotInventory], var money: Map[Int, Int]) {

  def buy(selection: String, coins: Coin*) = {
    if (!slots.contains(selection)) throw new RuntimeException(s"This drink '$selection' does not exist.")

    slots(selection) match {
      case SlotInventory(_, 0) => throw new RuntimeException(s"Sorry, this sort of drink ('$selection') is empty.")
      case SlotInventory(price, amount) => {
        val inputMoney = coins.map(coin => coin.value).sum

        if (price > inputMoney)
          throw new RuntimeException(s"Not enough money ($inputMoney) for the selected drink ($price) was given.")

        selection
      }

    }

  }
}

object Automate {

}
