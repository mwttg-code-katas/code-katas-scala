# Water between 2D Towers

## Description
In a two dimensional world, there is a place where some towers were build. 
When it rains for a long time, all convex enclosures are completely filled with water.

###  Input
As puzzle input you get an Array/List of the height of each tower (in Units)

### Task
Write a method/function to calculate the amount of collected water (in Units), which is collected between the towers.

### Bonus
If you have enough time, create a visualization
* in text mode
* in graphic mode

## Example
### Input
```
[5, 3, 7, 2, 6, 4, 5, 9, 1, 2]
```

### Visualization
without water
```
9               ██
8               ██
7     ██        ██
6     ██  ██    ██
5 ██  ██  ██  ████
4 ██  ██  ████████
3 ██████  ████████
2 ████████████████  ██
1 ████████████████████
```

with water
```
9               ██
8               ██
7     ██≈≈≈≈≈≈≈≈██
6     ██≈≈██≈≈≈≈██
5 ██≈≈██≈≈██≈≈████
4 ██≈≈██≈≈████████
3 ██████≈≈████████
2 ████████████████≈≈██
1 ████████████████████
```

### Solution
```
14 Units of Water
```

## Test Data
Test Data 1
```
[1, 5, 3, 7, 2]
```
Solution 1
```
2 Units of Water
```
Test Data 2
```
[5, 3, 7, 2, 6, 4, 5, 9, 1, 2]
```
Solution 2
```
14 Units of Water
```
Test Data 3
```
[2, 6, 3, 5, 2, 8, 1, 4, 2, 2, 5, 3, 5, 7, 4, 1]
```
Solution 3
```
35 Units of Water
```
Test Data 4
```
[5, 5, 5, 5]
```
Solution 4
```
0 Units of Water
```
Test Data 5
```
[5, 6, 7, 8]
```
Solution 5
```
0 Units of Water
```
Test Data 6
```
[8, 7, 7, 6]
```
Solution 6
```
0 Units of Water
```
Test Data 7
```
[6, 7, 10, 7, 6]
```
Solution 7
```
0 Units of Water
```

## Source
http://www.rosettacode.org/wiki/Water_collected_between_towers

