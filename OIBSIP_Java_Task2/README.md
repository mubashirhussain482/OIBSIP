## **Number Guessing Game**

A console-based Number Guessing Game developed in Java. The game allows users to select a difficulty level, guess a randomly generated number, receive higher/lower hints, track attempts, and play multiple rounds.

This project was developed as **Task 2** of the **OIBSIP Java Programming Internship**.

---

## **📌 Project Overview**

The Number Guessing Game provides a simple interactive console-based gaming experience.

Users can:

- Select a game difficulty: Easy, Medium, or Hard
- Generate a random number according to the selected difficulty
- Enter guesses using the Scanner class
- Receive "Your number is low" or "Your number is high" hints
- Track the number of remaining attempts
- Win the game by guessing the correct number
- Lose the game when the maximum attempts are exhausted
- View the correct number after losing
- Play multiple rounds
- Validate difficulty and Play Again input
- Handle invalid numerical input using exception handling
- Track round results using an ArrayList

---

## **🎯 Objectives**

The main objectives of this project are:

- Build a console-based game using Java
- Implement random number generation
- Provide different difficulty levels
- Implement user input using Scanner
- Provide higher/lower hints after each guess
- Track attempts during each round
- Implement a maximum attempt limit
- Implement input validation
- Handle invalid numerical input using InputMismatchException
- Provide a Play Again option
- Track results across multiple rounds using ArrayList
- Apply Java programming concepts such as loops, conditions, switch statements, and exception handling

---

## **🛠️ Technologies Used**

| Technology                 | Purpose                          |
| -------------------------- | -------------------------------- |
| Java                       | Application development          |
| Scanner                    | User input                       |
| Random                     | Random number generation         |
| ArrayList                  | Round history tracking           |
| InputMismatchException     | Invalid input handling           |
| Switch Statement           | Difficulty selection             |
| NetBeans IDE               | Development environment          |

---

## **🎮 Difficulty Levels**

The game provides three difficulty levels:

| Difficulty | Number Range | Maximum Attempts |
| ---------- | ------------ | ---------------- |
| Easy       | 1–50         | 10               |
| Medium     | 1–100        | 7                |
| Hard       | 1–200        | 5                |

The user can enter the difficulty as:

- `easy`
- `medium`
- `hard`

The program uses case-insensitive input handling, allowing inputs such as `Easy`, `EASY`, and `easy`.

---

## **✨ Features**

- Random number generation for every round
- Three difficulty levels
- Difficulty-based number ranges
- Difficulty-based maximum attempts
- User guess input
- "Your number is low" hint
- "Your number is high" hint
- Correct guess detection
- Attempt tracking
- Win and loss messages
- Correct number revealed after losing
- Play Again functionality
- Multiple round support
- Round history tracking
- Input validation
- Exception handling for invalid numerical input

---

## **🔄 Game Flow**

1. Start the application.
2. Display the difficulty selection.
3. User selects Easy, Medium, or Hard.
4. Generate a random target number according to the selected difficulty.
5. Set the maximum attempts.
6. Ask the user to enter a guess.
7. Validate the entered guess.
8. Compare the guess with the target number.
9. Display a low or high hint if the guess is incorrect.
10. Decrease the remaining attempts.
11. Continue until the user guesses correctly or runs out of attempts.
12. Display the result of the round.
13. Store the round result.
14. Ask the user whether they want to play again.
15. Start a new round if the user enters Yes.
16. End the game when the user enters No.

---

## **📊 Round Tracking**

The game uses an `ArrayList<String>` to maintain the history of completed rounds.

Round results can be displayed in the following format:

```text
Round 1 - Guessed in 4 attempts
Round 2 - Lost
Round 3 - Guessed in 2 attempts
