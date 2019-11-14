package org.drink.dispenser

final case class EuroCoin(valueInCent: Int)

class CashUnit(var coins: Map[Int, Int]) {

  def pay(price: Int, payedCoins: Int*) = {
    val payedSum = payedCoins.sum
    if (price > payedSum) {
      None
    } else {
      val exchangeValue = payedSum - price
    }
  }

}
