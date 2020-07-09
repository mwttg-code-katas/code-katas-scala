# Four is Magic

## Task

Write a function/method/class that takes a number and returns an English text sequence starting with the English cardinal representation of that integer, the word 'is' and then the English cardinal representation of the count of characters that made up the first word, followed by a comma.
Continue the sequence by using the previous count word as the first word of the next phrase, append 'is' and the cardinal count of the letters in that word.
Continue until you reach four. 
Since four has four characters, finish by adding the words 'four is magic' and a period. 
All integers will eventually wind up at four.

### Example

For instance, suppose your are given the integer **3**. 
Convert **3** to **Three**, add **is** , then the cardinal character count of three, which is **five**, with a comma (**,**) to separate it from the next phrase. 
Continue the sequence **five is four**, (five has four letters), and finally, **four is magic**.
```
Three is five, five is four, four is magic.
```

### More Examples

```
Zero is four, four is magic.
One is three, three is five, five is four, four is magic.
Two is three, three is five, five is four, four is magic.
Three is five, five is four, four is magic.
Four is magic.
Five is four, four is magic.
Six is three, three is five, five is four, four is magic.
Seven is five, five is four, four is magic.
Eight is five, five is four, four is magic.
Nine is four, four is magic.
```

## Guidelines

* You may assume the input will only contain integer numbers.
* Cardinal numbers between 20 and 100 may use either hyphens or spaces as word separators but they must use a word separator. (23 is twenty three or twenty-three not twentythree.)
* Cardinal number conversions should follow the English short scale. (billion is 1e9, trillion is 1e12, etc.)
* Cardinal numbers should not include commas. (20140 is twenty thousand one hundred forty not twenty thousand, one hundred forty.)
* When converted to a string, 100 should be one hundred, not a hundred or hundred, 1000 should be one thousand, not a thousand or thousand.
* When converted to a string, there should be no and in the cardinal string. 130 should be one hundred thirty not one hundred and thirty.
* When counting characters, count all of the characters in the cardinal number including spaces and hyphens. One hundred fifty-one should be 21 not 18.
* The output should follow the format "N is K, K is M, M is ... four is magic." (unless the input is 4, in which case the output should simply be "four is magic.")
* The output can either be the return value from the function, or be displayed from within the function.
* You are encouraged, though not mandated to use proper sentence capitalization.
* You may optionally support negative numbers. -7 is negative seven.

# Source
http://rosettacode.org/wiki/Four_is_magic

# Links
Algorithm: http://blackwasp.co.uk/NumberToWords.aspx
