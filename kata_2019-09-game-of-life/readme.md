# Game of Life

## Task
Write a program, which can simulate [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
As input you get:
* a text file of generation zero (there is no limit for the size [width x height])
* the amount of generations to create

Example of input file:
```
........
....*...
...**...
........
```
The process of creating a new generation is following these rules:

#### The Rules
1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

### Hint
The next generation of the example from above would look like:
```
........
...**...
...**...
........
```

## Result
The result should be a output (terminal/File) of the last generation.

### Bonus
Show each generation as animated output (Slide-Show).

## Source
http://codingdojo.org/kata/GameOfLife/