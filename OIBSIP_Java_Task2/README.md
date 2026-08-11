**NUMBER GUESSING GAME**

**Project Overview**

The Number Guessing Game is a Java-based console application in which the computer generates a random number and the player attempts to guess it within a limited number of attempts.

After each guess, the program provides a hint indicating whether the guessed number is too high or too low. The player wins when the correct number is guessed and loses when all available attempts are used.

The game also supports multiple rounds, difficulty levels, input validation, and round history tracking.

**Objectives**

- Generate a random number for each round.
- Allow the user to guess the generated number.
- Provide "Too High" and "Too Low" hints.
- Track the number of attempts used and remaining attempts.
- End the round when the number is guessed correctly or attempts run out.
- Provide a Play Again option.
- Track the results of multiple rounds.
- Provide different difficulty levels with different number ranges and attempt limits.
- Handle invalid user input without terminating the program.

**Technologies Used**

- Java
- Scanner
- Random
- ArrayList
- Exception Handling
- Loops
- Conditional Statements
- Switch Statement

**Difficulty Levels**

The game provides three difficulty levels:

**Easy**
- Number range: 1–50
- Maximum attempts: 10

**Medium**
- Number range: 1–100
- Maximum attempts: 7

**Hard**
- Number range: 1–200
- Maximum attempts: 5

**Features**

**1. Random Number Generation**

A new random target number is generated at the start of every round according to the selected difficulty level.

**2. Difficulty Selection**

The player can select Easy, Medium, or Hard difficulty.

The difficulty is handled using a String-based switch statement. The input is converted to lowercase so that inputs such as Easy, EASY, and easy are handled correctly.

**3. Guess Input**

The player enters a numerical guess using the Scanner class.

The program uses InputMismatchException handling to prevent invalid non-numeric input from crashing the application.

**4. Guess Hints**

After every incorrect guess, the program provides a hint:

- "Your number is low" when the guess is lower than the target number.
- "Your number is high" when the guess is higher than the target number.

**5. Attempt Limitation**

Each difficulty has a different maximum number of attempts.

When the remaining attempts reach zero, the player loses the round and the correct number is revealed.

**6. Winning Condition**

If the player guesses the correct number, the program displays a winning message and reveals the guessed target number.

**7. Play Again**

After every round, the player is asked:

"Do you want to play again (yes/no):"

Only "yes" or "no" is accepted. Invalid responses cause the program to ask again.

When the player chooses "yes", a new round starts with a new difficulty selection and a newly generated random number.

**8. Round Tracking**

The program uses an ArrayList to store the history of completed rounds.

Round information can be stored in a format such as:

Round 1 - Guessed in 4 attempts
Round 2 - Lost
Round 3 - Guessed in 2 attempts

The round number is increased after each completed round.

**9. Input Validation**

The program validates user input in several areas:

- Difficulty must be Easy, Medium, or Hard.
- Guess input must be an integer.
- Play Again input must be Yes or No.
- Invalid numerical input is handled using InputMismatchException.

**Game Flow**

1. Start the application.
2. Display the difficulty selection.
3. User selects Easy, Medium, or Hard.
4. Generate a random target number according to the selected difficulty.
5. Display the maximum available attempts.
6. User enters a guess.
7. Compare the guess with the target number.
8. Display a Too High or Too Low hint if the guess is incorrect.
9. Decrease the remaining attempts.
10. Continue until the player guesses correctly or runs out of attempts.
11. Display the win or loss result.
12. Store the round result in the round history.
13. Ask whether the player wants to play again.
14. Start another round if the player chooses Yes.
15. Display the game-ending message when the player chooses No.

**Example Gameplay**

----- Number Guessing Game -----

Choose difficulty (easy, medium, hard): medium

Medium mode selected.
7 attempts available

Guess the number: 50
Your number is high
6 attempts left

Guess the number: 25
Your number is low
5 attempts left

Guess the number: 37
Correct!

You win the game.
The number is 37

Do you want to play again (yes/no): yes

A new round starts with a new difficulty selection and a new random number.

**Input Validation Example**

If the user enters a non-numeric value when a number is required:

Invalid input. Please enter a number.

The program clears the invalid input and asks the user to enter a number again.

If an invalid difficulty is entered:

Invalid difficulty. Try again.

If an invalid Play Again response is entered:

Invalid input. Please type yes or no.

**Project Structure**

The project is implemented as a console-based Java application.

Main class:
Practice5

The application currently keeps the game logic inside the main() method and uses Java's built-in classes for random number generation, user input, exception handling, and round history.

**Java Concepts Demonstrated**

- Variables and data types
- String handling
- String comparison
- String switch statement
- if-else statements
- do-while loops
- while loops
- Random number generation
- Scanner input
- ArrayList
- Exception handling with InputMismatchException
- Boolean variables
- Counter variables
- User input validation

**How to Run**

1. Install the Java Development Kit (JDK).
2. Clone or download the project from GitHub.
3. Open the project in a Java-supported IDE such as NetBeans, IntelliJ IDEA, or VS Code.
4. Compile the Java source file.
5. Run the Practice5 class.
6. Follow the instructions displayed in the console.

**Author**

Mubashir Hussain

**Project Type**

Console-Based Java Application

**License**

This project is created for educational and internship project purposes.
