# Marble Maze

## Description
Original idea by Gernot Pointner, slightly modified for simplification.

Given is a box with a maze inside of it. This maze is given to you as a text file. 
The first row of the text file describes the input positions for a marble and the last row of the text file describes the (maybe) output positions of the marble, which was insert. 
A text file could look like this:
```
XX XXXXX XXXXXXXXXXXXXX XXXX
X  XXXXX XXXXXXXXXXXXXX XXXX
X XXXXXX     XXXXXX       XX
X XXXXXXXX XXXXXXXXXX XXXXXX
X  XXXXXXXXXXXXXXXXXX XXXXXX
XX XXXXXXXXXXXXXXXXXX XXXXXX
```
As you can see
* Input 1 leads to output 1 - the left way
* Input 2 leads to nothing - the middle way
* Input 3 leads to output 2 - the right way

Textfile
* X -means wall
* ' ' (Space) means 'a way' - where the marble can roll on

Inputs
* are the first row
* use the index (x-coordinate)

Outputs
* are the last row
* use the index (x-coordinate)

## Task
Write an application which generates for a maze (given as a text file), a description which inputs leads to which outputs. e.g:
* `Input 1 → Output 1`
* `Input 2 → None`
* `Input 3 → Output 2`

## Notes
* the text file is the side view of the maze
  * that means you put in a marble on top and the marble is rolling/falling down
* a marble can't roll up
  * The following will not lead to an output
  ```
  X XXXXX
  X X   X
  X   X X
  XXXXX X
  ```
* a marble always rolls, if a way is available
  *  means the marble will go left or right (50% / 50%) and will not rest
  ```
  XXXXXXXXXXXXXX XXXXXXXXXXXXXX
  X                           X
  X XXXXXXXXXXXXXXXXXXXXXXXXX X
  ```
* ways can split up or merge together
  * A marble can't go slantwise, that means, the following creates no way (only 90° turns are allowed - no 45°)
  ```
  X XXX
  XX XX
  XXX X
  ```
* Not all ways are used by the marble
  * in this example the output 1 (the left one) and output 4 (the right one) is something the marble can't reach (because the marble will go down before → can't jump over holes)
  ```
  XXXXXXXXXXXX XXXXXXXXXXXXXXX
  X                          X
  XX XXXXX XXXXXX XXXXXXXXX XX
  ```
* marbles fall straight down (there are no side g-forces)
  * the exit left and the exit right is something the marble can't reach (only the exit in the middle (→ straight falling down)
  ```
  XXXXX XXXXXX
  X          X
  X          X
  X          X
  X XXX XXXX X
  ``` 
* A marble is nearly as big as a 'X' ;)

## Test-Data with Solution

### Simple Falling Down
```
X X
X X
X X
```
```
input: Set(1) has the following outputs: Set(1)
```

### Simple Goes Left
```
XX X
X  X
X XX
```
```
input: Set(2) has the following outputs: Set(1)
```

### Simple Goes Right
```
X XX
X  X
XX X
```
```
input: Set(1) has the following outputs: Set(2)
```

### Split
```
XXX XXX
X     X
X XXX X
```
```
input: Set(3) has the following outputs: Set(1, 5)
```

### Merge
```
X XXXXX X
X       X
XXXX XXXX
```
```
input: Set(1) has the following outputs: Set(4)
input: Set(7) has the following outputs: Set(4)
```

### Simple No Solution
```
X X
X X
XXX
```
```
input: Set(1) has the following outputs: Set()
```

### Multiple Ways
```
XXXXX X X XXXXX
XX    X X   XXX
XXX XXX XXX XXX
X     X X     X
X XXX X X XXX X
```
```
input: Set(5) has the following outputs: Set(1, 5)
input: Set(7) has the following outputs: Set(7)
input: Set(9) has the following outputs: Set(9, 13)
```

### Marble Don't Jump Left
```
XXXXX X
X     X
X X XXX
```
```
input: Set(5) has the following outputs: Set(3)
```

### Marble Don't Jump Right
```
X XXXXX
X     X
XXX X X
```
```
input: Set(1) has the following outputs: Set(3)
```

### Marble Don't Jump Up
```
X XXXXX
X X   X
X   X X
XXXXX X
```
```
input: Set(1) has the following outputs: Set()
```

### Big Space (falling down)
```
XXXXX XXXXXX
X          X
X          X
X          X
X XXX XXXX X
```
```
input: Set(5) has the following outputs: Set(5)
```
