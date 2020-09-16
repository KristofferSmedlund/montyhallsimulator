# montyhall
Project to reproduce the famous Monty Hall problem

How to run:
build with
 * mvn package
 
then run with
* java -jar target/montyhall-1.0-SNAPSHOT.jar boxPreference shouldSwitch amountOfAttempts

where 
* boxpreference is 0,1,2
* shouldSwitch true | false
* amountOfAttempts > 0


Possible improvements:
* I'd like some state managing for the Gameshow object which validates that for example a user does not switch boxes twice and such.
* Improve user customizability by letting the user provide more arguments, for example switch every third time etc