# Game of Pig

## Task
Create a program to keep the score for, and simulate dice throws for, a two-person game.

## Game Rules
The [Game of Pig](https://en.wikipedia.org/wiki/Pig_(dice_game)) is a multiplayer game played with a single six-sided die.
The object of the game is to reach 100 points or more. 
The play is taken in turns. 
On each person's turn that person has the option of either:
* Rolling the dice
  * where a roll of two to six is added to their score for that turn and the player's turn continues as the player is given the same choice again;
  * or a roll of 1 loses the player's total points for that turn and their turn finishes with play passing to the next player.
* Holding
  * the player's score for that round is added to their total and becomes safe from the effects of throwing a 1 (one).  
  * The player's turn finishes with play passing to the next player.

The first person who reaches 100 or more points wins the game.

### Example
* The first player is Donald,
  * he begins a turn with a roll of 5.
  * Donald could hold and score 5 points
    * but chooses to roll again.
    * Donald rolls a 2, and could hold with a turn total of 7 points
    * Donald chooses to roll again.
      * Donald rolls a 1, and must end his turn without scoring.
      
Now the next players starts

* The next player, Alexis
  * Alexis rolls the sequence 4-5-3-5-5
  * After this sequence she chooses to hold
    * A total of 22 points is add to her score.
    
## Constraints
* The first thing you have to do is, to decide which option of the game you want to implement
  * Player vs. Player
  * Player vs. CPU
  * CPU vs. CPU
* if you have time and motivation left you can implement the other options
* if you choose to implement a CPU player
  * don't waste to much time for artificial intelligence
    * for the beginning random may be enough
