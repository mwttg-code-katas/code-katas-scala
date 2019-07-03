# Sudoku
## Task
Write a program which can solve sudoku puzzles.

### Description
A sudoku puzzle looks like:
```
 . . 4 ┃  8 . . ┃  . 1 7
 6 7 . ┃  9 . . ┃  . . .
 5 . 8 ┃  . 3 . ┃  . . 4
━━━━━━━╋━━━━━━━━╋━━━━━━━━
 3 . . ┃  7 4 . ┃  1 . .
 . 6 9 ┃  . . . ┃  7 8 .
 . . 1 ┃  . 6 9 ┃  . . 5
━━━━━━━╋━━━━━━━━╋━━━━━━━━
 1 . . ┃  . 8 . ┃  3 . 6
 . . . ┃  . . 6 ┃  . 9 1
 2 4 . ┃  . . 1 ┃  5 . .
```
Every spot in the puzzle belongs to a (horizontal) row and a (vertical) column, as well as to one single 3×3 square (which we call "square" for short). 
At the beginning, some of the spots carry a single-digit number between 1 and 9. 
The problem is to fill the missing spots with digits in such a way that every number between 1 and 9 appears exactly once in each row, in each column, and in each square.

### Hint
The solution of the sudoku puzzle from above looks like:
```
 9 3 4 ┃  8 2 5 ┃  6 1 7
 6 7 2 ┃  9 1 4 ┃  8 5 3
 5 1 8 ┃  6 3 7 ┃  9 2 4
━━━━━━━╋━━━━━━━━╋━━━━━━━━
 3 2 5 ┃  7 4 8 ┃  1 6 9
 4 6 9 ┃  1 5 3 ┃  7 8 2
 7 8 1 ┃  2 6 9 ┃  4 3 5
━━━━━━━╋━━━━━━━━╋━━━━━━━━
 1 9 7 ┃  5 8 2 ┃  3 4 6
 8 5 3 ┃  4 7 6 ┃  2 9 1
 2 4 6 ┃  3 9 1 ┃  5 7 8
```
## Source
Problem 97 from: http://aperiodic.net/phil/scala/s-99/


