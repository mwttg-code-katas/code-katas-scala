# 'I' before 'E' except after 'C'

# Tasks
The phrase ["I before E except after C"][mnemonic] is a widely known mnemonic which is supposed to help when spelling English words.

## Task
Using the wordlist from: http://wiki.puzzlers.org/pub/wordlists/unixdict.txt, check if the two sub-clauses of the phrase are plausible individually:
* "I before E when not preceded by C"
* "E before I when preceded by C"

If both sub-phrases are plausible then the original phrase can be said to be plausible.

Something is plausible if the number of words having the feature is more than two times the number of words having the opposite feature (where feature is 'ie' or 'ei' preceded or not by 'c' as appropriate).

## Bonus
As a bonus task use the entries from the table of [Word Frequencies in Written and Spoken English: based on the British National Corpus][wordlist2] (selecting those rows with three space or tab separated words only), to see if the phrase is plausible when word frequencies are taken into account.

# Source
* http://www.rosettacode.org/wiki/I_before_E_except_after_C

[mnemonic]: https://en.wikipedia.org/wiki/I_before_E_except_after_C
[wordlist]: http://wiki.puzzlers.org/pub/wordlists/unixdict.txt
[wordlist2]: http://ucrel.lancs.ac.uk/bncfreq/lists/1_2_all_freq.txt
