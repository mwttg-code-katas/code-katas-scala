# Number Scanner

## Task:
You are one of Santas Helpers. You are working in the present storehouse. Last year a co-worker installed a stylish label machine 
to label all the presents for this year with an `ID`. These `IDs` looks like:

      _  _     _  _  _  _  _ 
    | _| _||_||_ |_   ||_||_|
    ||_  _|  | _||_|  ||_| _| 

each number of these `IDs` is a 3x3 field with ASCII chars (also the number 1). This year you want to optimize the sledge-packing
process. You want to collect all presents for one region in one sledge-packing area. Therefore you have to scan the `ID` with your 
hand-scanner and ask the database for the address. The problem is, the id in the database is a number. You need an algorithm to 
convert the `ID`, produced by the hand-scanner, to a number.

The output should look like:

    123456789
