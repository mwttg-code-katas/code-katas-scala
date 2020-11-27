# Stones and Jewels

## Task
Create a function which takes two string parameters: 'stones' and 'jewels' and returns an integer.
Both strings can contain any number of upper or lower case letters. However, in the case of 'jewels', all letters must be distinct.
The function should count (and return) how many 'stones' are 'jewels' or, in other words, how many letters in 'stones' are also letters in 'jewels'.

Note:
* Only letters in the [ISO basic Latin alphabet][wikipedia] i.e. 'A to Z' or 'a to z' need be considered.
A lower case letter is considered to be different to its upper case equivalent for this purpose i.e. 'a' != 'A'.
The parameters do not need to have exactly the same names.
Validating the arguments is unnecessary.

## Examples

### Example 1
Input:
```
stones := "aAAbbbb"
jewels := "aA"
```
Result:
````
3
````

### Example 2
Input:
```
stones := "ZZ"
jewels := "z"
```
Result:
```
0
```

## Source
http://www.rosettacode.org/wiki/Jewels_and_stones

# Happy Numbers

## Task
Find and print the first 8 happy numbers.

## Description
From [Wikipedia][wikipedia2]:

A happy number is defined by the following process:

* Starting with any positive integer,
  * replace the number by the sum of the squares of its digits, and repeat the process until the number equals   1   (where it will stay),   
  or it loops endlessly in a cycle which does not include   1.  


Those numbers for which this process end:
 * in   1   are       happy   numbers,  
 * while   those numbers   that   do   not   end in   1   are   unhappy   numbers.

## Example
Number = 19
```
19 = 1 * 1 + 9 * 9 = 82
82 = 8 * 8 + 2 * 2 = 68
68 = 6 * 6 + 8 * 8 = 100
100 = 1 * 1 + 0 * 0 + 0 * 0 = 1 ---> 19 is a happy number
```

## Solution
```
List(1, 7, 10, 13, 19, 23, 28, 31)
```
## Source
http://www.rosettacode.org/wiki/Happy_numbers

[wikipedia]: https://en.wikipedia.org/wiki/ISO_basic_Latin_alphabet
[wikipedia2]: https://en.wikipedia.org/wiki/Happy_number
