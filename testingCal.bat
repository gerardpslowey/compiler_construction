@echo off
echo Generating antlr4 files
CALL antlr4 cal.g4 -no-listener

echo Compiling Java files
javac *.java

echo ---------------------------------
CALL java Cal ..\test_files\test1.cal
CALL java Cal ..\test_files\test2.cal
CALL java Cal ..\test_files\test3.cal
CALL java Cal ..\test_files\test4.cal
CALL java Cal ..\test_files\test5.cal
CALL java Cal ..\test_files\test6.cal
CALL java Cal ..\test_files\test7.cal
echo ---------------------------------
pause