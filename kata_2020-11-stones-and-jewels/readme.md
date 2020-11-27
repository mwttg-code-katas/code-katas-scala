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


[wikipedia]: https://en.wikipedia.org/wiki/ISO_basic_Latin_alphabet
