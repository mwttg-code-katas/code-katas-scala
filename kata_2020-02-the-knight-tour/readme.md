# The Knight's tour

## Task

How can a knight jump on an N x N chessboard in such a way that it visits every square exactly once?

Implement an algorithm that gets as input:
 * the size of the chessboard
 * the start position of the knight
 
and produces as output:
* a list of positions (the way the knight took)

## Hints

### Possible Solutions for a 5x5 chessboard
```
 |  0   1   2   3     4
------------------------
1| 304  0   56    0  304
 |
2|  0   56   0   56   0
 |
3|  56  0   64   0    56
 |
4|  0   56    0  56   0
 |
5| 304   0   56   0  304
```

## Source
* http://aperiodic.net/phil/scala/s-99/p91.scala

## Links
* https://stackoverflow.com/questions/31411487/knights-tour-on-a-5-x-5-board-start-from-any-square
