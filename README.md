# didi-take-home-test

Take Home Test from DiDi

Word Anagram

Requirements

Input: a set of input characters, ranging from a-z, case-insensitive.

Output: all the possible English words from the dictionary that could be composed of these characters, case-insensitive. Note that each of these characters can only be used once. 

The possible English words could be fetched from, for example,  https://raw.githubusercontent.com/lad/words/master/words which is a copy of /usr/share/dict/words.

Ensure the main program can be run in https://coderpad.io/




Since we want to find all possible Englist words that could be composed of these characters. 

So if we 
	input with set <'a', 'b', 'c'>, we should return: <>, which is an empty list
	
	input with set <>, return with list of string: <>

	input with set <'a', 'b'>, return with list of string: <"ab">

	input with set <'a', 'A', 'r', 'u'>, return with list of string: <"aaru">  (since we are finding results with case insensitive)

	input with set <'a', 'c', 'e', 'r'>, we should return a list of string: <"acer">  ("acer" is the only string that is composed of these four characters).