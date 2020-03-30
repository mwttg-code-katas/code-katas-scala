# The Knight's tour

## Task

How can a knight jump on an N x N chessboard in such a way that it visits every square exactly once?

Implement an algorithm that gets as input:
 * the size of the chessboard
 * the start position of the knight
 
and produces as output:
* a list of positions (the way the knight took)

## Bonus
* How many different tours can a knight take on a N x N chessboard, for a certain startPosition?
* Does a tour exists which ends in a loop (startPosition = endPosition)

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
* [A link](http://www.cs.nott.ac.uk/~pszgxk/papers/cec05knights.pdf)
* http://gaebler.us/share/Knight_tour.html
* https://www.cma.fct.unl.pt/sites/www.cma.fct.unl.pt/files/knights_tours_final.pdf
* https://www.mayhematics.com/p/figuredtours.pdf

## Additional nodes

This problem gets very quick, very difficult, so for beginning a 5x5 chess board is sufficient.
