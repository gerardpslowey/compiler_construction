@echo off
echo Generating antlr4 files
CALL antlr4 cal.g4 -no-listener

echo Compiling Java files
javac *.java

echo ---------------------------------
CALL java Cal ..\tests\test1.cal
CALL java Cal ..\tests\test2.cal
CALL java Cal ..\tests\test3.cal
CALL java Cal ..\tests\test4.cal
CALL java Cal ..\tests\test5.cal
CALL java Cal ..\tests\test6.cal
CALL java Cal ..\tests\test7.cal
echo ---------------------------------
pause