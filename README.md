# CSX42: Assignment 2
## Name: Sayali Thorat

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Citations :

https://www.geeksforgeeks.org/java/
https://stackoverflow.com/
https://www.tutorialspoint.com/design_pattern/state_pattern.html

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

I havent implemented logger file yet so the arguments to be passed for my program should be only inputFile and outputFile.

In the folder: "sayali_thorat_assign_2/racingDrivers" run the following command:

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt

-----------------------------------------------------------------------
## Description:

I have defined all my calculation methods in RaceContext.java file and I have setPositions and states in my DriverContext.java file.
I have used Driver.java to call my objects of files and accept arguments from user.
I have tried to implement state_pattern.
calculateLeader method in RaceContext is where I am finding the positions of drivers based on their totalDistanceTravelled.
I have documented my javadoc style comments in my doc folder.
I have tested my code based on the input.txt file which I have submitted, the same one which was given to us.


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- 06/28/2019
