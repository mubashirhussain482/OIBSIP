# **Number Guessing Game**

A console-based Number Guessing Game developed in Java. The game generates a random number and allows the user to guess it within a limited number of attempts.

The project was developed as **Task 2** of the **OIBSIP Java Programming Internship**.

---

## **📌 Project Overview**

The Number Guessing Game is a command-line application where the computer generates a random number and the user attempts to guess it.

After each guess, the game provides a hint indicating whether the user's guess is lower or higher than the target number.

The game supports multiple rounds and provides a summary of the completed rounds when the game ends.

---

## **🎯 Objectives**

The main objectives of this project are:

* Generate random numbers using Java
* Allow users to enter guesses through the console
* Provide higher/lower hints
* Track the number of attempts used
* Limit the number of attempts per round
* Allow the user to play multiple rounds
* Maintain a history of completed rounds
* Implement difficulty levels
* Handle invalid user input

---

## **🛠️ Technologies Used**

| Technology               | Purpose                  |
| ------------------------ | ------------------------ |
| Java                     | Application development  |
| `Random`                 | Random number generation |
| `Scanner`                | User input               |
| `ArrayList`              | Round history storage    |
| `InputMismatchException` | Invalid input handling   |
| NetBeans IDE             | Development environment  |

---

## **✨ Features**

### **1. Difficulty Levels**

The game provides three difficulty levels:

| Difficulty | Number Range | Maximum Attempts |
| ---------- | -----------: | ---------------: |
| Easy       |         1–50 |               10 |
| Medium     |        1–100 |                7 |
| Hard       |        1–200 |                5 |

The user selects the desired difficulty at the beginning of each round.

---

### **2. Random Number Generation**

At the beginning of every round, the program generates a random target number according to the selected difficulty.

Examples:

```text
Easy   → 1–50
Medium → 1–100
Hard   → 1–200
```

Java's `Random` class is used for generating the target number.

---

### **3. Guessing and Hints**

The user enters a numerical guess.

The program provides feedback:

* **Your number is low** — when the guess is lower than the target
* **Your number is high** — when the guess is higher than the target
* **You win the game** — when the guess is correct

---

### **4. Attempt Tracking**

The game keeps track of the number of remaining attempts.

The maximum attempts depend on the selected difficulty:

* Easy → 10 attempts
* Medium → 7 attempts
* Hard → 5 attempts

The remaining attempts are displayed during the game.

---

### **5. Losing a Round**

If the user uses all available attempts without guessing the target number, the round ends.

The program displays:

```text
You lose. Out of moves
The number was [target number]
```

The result is then added to the round history.

---

### **6. Multiple Rounds**

After completing a round, the user is asked:

```text
Do you want to play again (yes/no):
```

If the user enters `yes`, a new round begins with a newly generated random number.

If the user enters `no`, the game ends.

---

### **7. Round History**

The program stores the result of each completed round using an `ArrayList`.

For successful rounds, the history records the round number and the number of attempts used.

Example:

```text
----- Round Summary -----
Round 1 - Guessed in 3 attempts out of 7
Round 2 - Guessed in 5 attempts out of 10
Round 3 - Lost
```

---

### **8. Input Validation**

The program handles invalid input using `InputMismatchException`.

If the user enters something other than a number when a guess is required, the program displays:

```text
Invalid input. Please enter a number.
```

The difficulty selection is also validated. If an invalid difficulty is entered, the user is asked to select again.

The Play Again option only accepts:

```text
yes
```

or

```text
no
```

---

## **🏗️ Program Structure**

```text
OIBSIP_Java_Task2
│
├── OIBSIP_Java_Task2.java
└── README.md
```

The project is implemented as a console-based Java application using a single main class.

---

## **🔄 Application Flow**

```text
              ┌──────────────────────┐
              │      Start Game      │
              └──────────┬───────────┘
                         │
                         ▼
              ┌──────────────────────┐
              │ Select Difficulty    │
              │ Easy / Medium / Hard │
              └──────────┬───────────┘
                         │
                         ▼
              ┌──────────────────────┐
              │ Generate Random      │
              │ Target Number        │
              └──────────┬───────────┘
                         │
                         ▼
              ┌──────────────────────┐
              │ Enter Guess          │
              └──────────┬───────────┘
                         │
                 ┌───────┴────────┐
                 │                │
                 ▼                ▼
          Guess Correct?       Incorrect
                 │                │
                 ▼                ▼
              Win          High / Low Hint
                 │                │
                 │                ▼
                 │         Attempts Remaining?
                 │          │             │
                 │         Yes            No
                 │          │             │
                 │          └──► Guess     ▼
                 │                   Lose
                 └──────────┬──────────────┘
                            │
                            ▼
                    Play Again?
                     │          │
                    Yes         No
                     │          │
                     ▼          ▼
                New Round    Game End
                                │
                                ▼
                         Round Summary
```

---

## **▶️ How to Run**

### **Prerequisites**

Make sure the following are installed:

* Java JDK
* NetBeans IDE or another Java IDE

### **Steps**

1. Clone or download the repository.

2. Open the project in NetBeans.

3. Open:

```text
OIBSIP_Java_Task2.java
```

4. Compile and run the program.

5. Select a difficulty level:

```text
easy
medium
hard
```

6. Enter numerical guesses.

7. Follow the hints and attempt counter.

8. Choose whether to play another round after each game.

---

## **🧪 Testing**

The game was tested for the following scenarios:

### **Difficulty Testing**

* Easy difficulty
* Medium difficulty
* Hard difficulty
* Invalid difficulty input

### **Guess Testing**

* Correct guess
* Guess lower than target
* Guess higher than target
* Invalid non-numeric input

### **Attempt Testing**

* Winning within the available attempts
* Using all available attempts
* Displaying the target number after losing

### **Round Testing**

* Playing multiple rounds
* Selecting different difficulties in different rounds
* Round history generation
* Ending the game with `no`

### **Play Again Testing**

* Valid `yes` input
* Valid `no` input
* Invalid Play Again input

---

## **📚 Java Concepts Used**

This project demonstrates the use of:

* Variables and data types
* `if-else` statements
* `switch-case`
* `while` loops
* `do-while` loops
* `Random`
* `Scanner`
* `ArrayList`
* Exception handling
* `InputMismatchException`
* String handling
* Boolean variables
* Multiple rounds and state tracking

---

## **👨‍💻 Author**

**Mubashir Hussain**

BS Software Engineering Student

Developed as part of the **OIBSIP Java Programming Internship**.

---

## **📄 License**

This project was developed for educational and internship purposes.
