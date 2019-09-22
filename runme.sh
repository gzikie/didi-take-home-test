#!/bin/sh

# THE_CLASSPATH=
# PROGRAM_NAME=findWords.java
# CLASS_NAME=findWords

# cd src
# for i in `ls ../lib/*.jar`
#     do
#     THE_CLASSPATH=${THE_CLASSPATH}:${i}
# done

# javac -classpath ".:${THE_CLASSPATH}" $PROGRAM_NAME

# if [ $? -eq 0 ]
# then
#     echo "compile worked!"
# fi

# java -classpath ".:${THE_CLASSPATH}" $CLASS_NAME
# then
# 	echo "finished finding words"
# fi

text=""
text+="q: quit.\n"


#printf "$text"
selected=0
while [ ${selected} == 0 ]
do
	javac ./findWords.java

	java ./findWords


done
