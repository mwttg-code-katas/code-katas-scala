# Drink Dispenser

## Task
You got the order to develop the central business logic for a 'Drink Dispenser' with money exchange functionality. 
The automate has different slots with a separate price for each slot. 
One slot represents the type of one sort of drink. 
The following drinks are offered by the machine:

| Drink             | Price (in €) | 
|:------------------|-------------:|
| Water             |         0.80 |
| Nuka Cola         |         1.20 |
| Nuka Cola Quantum |         3.40 |
| Duff Beer         |         2.30 |
| Booty Sweat       |         2.50 |

The automate accepts the following coins:

* 10 Cent
* 20 Cent
* 50 Cent
* 1 Euro ( = 100 Cent)
* 2 Euro ( = 200 Cent)

The main function of your program could look like:

* `DinkAndChange buy(selection: Drink, money: Coins)`
* `DinkAndChange buy(final Drink selection, final Coin... money)`

The function returns either the selected drink (with exchange money = some coins) or an error, because:

* the slot for the drink is empty
* the money which was given, was to low
* the automate has no valid exchange money

The drink inventory and the exchange money of the automate are limited, so an interface/functionality/function/method for re-filling the drinks and money is needed.

### Example

A customer buys a Nuka Cola and pays with a 2 € coin.

The automate will return the Nuka Cola and the exchange money:

* one 50 cent coin
* one 20 cent coin
* one 10 cent coin

### Bonus Task

Add some more flexibility, like:

* different locations (where the automate is installed) have different prices for the drinks
* different currency with different values of the coins (60, 40, 10 for example)

### Delimitation

* You __don't__ need to implement the functionality to persist the automate state inside a database, a transient solution is enough (a state inside the program)
* You __don't__ need to offer a GUI