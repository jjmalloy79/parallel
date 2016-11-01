#!/usr/bin/env python

# example take from:
# http://www.michael-noll.com/tutorials/writing-an-hadoop-mapreduce-program-in-python/
# example runs without hadoop
# echo "a b c d e" | ./mapper.py
# echo "a b c d e" | ./mapper.py | sort -k1
# echo "a b c d e" | ./mapper.py | sort -k1 | ./reducer.py
# cat data/4300-0.txt  | ./mapper.py | sort -k1 | ./reducer.py

import sys
players = []
allPlayers = []
homeRuns = []

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    words = line.split(",")
    # increase counters
#count = words.size()
    for word in words:
		temp = word.replace("\t","")
		temp = word.replace("\n","")	
		if((temp != "")):
			temp.split(" " , 1)
			allPlayers.append(temp)
print (allPlayers[1])        
		# write the results to STDOUT (standard output);
        # what we output here will be the input for the
        # Reduce step, i.e. the input for reducer.py
        # 
        # tab-delimited; the trivial word count is 1
		#players = words[1]
		#allPlayers.append(words[1])
#print(allPlayers)
