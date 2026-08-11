# **Online Examination System**

A GUI-based Online Examination System developed in Java using Swing. The system allows users to log in, update their profile, attempt a timed multiple-choice examination, navigate between questions, submit the exam, and view their final result.

This project was developed as **Task 4** of the **OIBSIP Java Programming Internship**.

---

## **📌 Project Overview**

The Online Examination System provides a simple graphical interface for conducting a timed multiple-choice examination.

Users can:

* Log in using predefined credentials
* Update their display name
* Change their password
* Start the examination
* Answer multiple-choice questions
* Navigate between questions using Previous and Next buttons
* Review previously selected answers
* Complete the examination within the given time
* Submit the examination manually
* Automatically finish the examination when the timer reaches zero
* View the final examination result
* View score, percentage, correct answers, incorrect answers, status, and time taken

The application is developed using **Java Swing** and follows an object-oriented structure with separate classes for users, questions, GUI frames, and the main application.

---

## **🎯 Objectives**

The main objectives of this project are:

* Build a desktop-based examination system using Java Swing
* Create a graphical login interface
* Implement user profile management
* Display multiple-choice questions
* Provide question navigation
* Implement a countdown examination timer
* Automatically submit the examination when time expires
* Calculate the examination score
* Display detailed examination results
* Apply object-oriented programming principles
* Organize the application into separate Java classes

---

## **🛠️ Technologies Used**

| Technology   | Purpose                                        |
| ------------ | ---------------------------------------------- |
| Java         | Application development                        |
| Java Swing   | Graphical User Interface                       |
| AWT          | GUI layouts, fonts, colors, and event handling |
| ArrayList    | Storing examination questions                  |
| Timer        | Countdown examination timer                    |
| NetBeans IDE | Development environment                        |

---

## **✨ Features**

### **1. User Login**

The system provides a login screen with:

* Username field
* Password field
* Empty-field validation
* Username and password verification
* Invalid credential error message
* Enter key support for login

The application uses predefined user credentials stored in the `User` object.

---

### **2. Profile Update**

After successful login, the user can update their profile.

The profile screen provides:

* Display name field
* New password field
* Profile update button
* Continue to Exam button

The user can:

* Update the display name
* Change the password
* Update both display name and password

The display name cannot be left empty.

---

### **3. Multiple-Choice Examination**

The examination contains **10 multiple-choice questions**.

Each question provides exactly **4 options**.

The system allows the user to:

* Select one answer
* Move to the next question
* Move back to the previous question
* Keep previously selected answers
* Submit the examination

---

### **4. Question Navigation**

The examination provides:

* **Previous** button
* **Next** button
* **Submit** button

The Previous button is disabled on the first question.

The Next button is disabled on the last question.

Selected answers are stored so that the user can navigate between questions without losing their selections.

---

### **5. Examination Timer**

The examination includes a countdown timer.

The total examination time is configured as:

```text
10 minutes
```

The timer displays the remaining time in:

```text
MM:SS
```

For example:

```text
Time Remaining: 09:45
```

When the timer reaches zero, the examination is automatically finished and the score is calculated.

---

### **6. Manual Submission**

The user can submit the examination using the **Submit** button.

Before submission, the system displays a confirmation dialog:

```text
Are you sure you want to submit the exam?
```

If the user confirms, the timer stops and the result is calculated.

---

### **7. Exam Exit Handling**

If the user attempts to close the examination window, the system asks for confirmation.

The user can choose whether to submit the examination and exit.

This prevents the examination from being accidentally closed without completing the submission process.

---

### **8. Automatic Score Calculation**

The system compares each selected answer with the correct answer.

The score is calculated based on the number of correctly answered questions.

For example:

```text
Score: 8 / 10
```

The system also calculates:

* Correct answers
* Incorrect answers
* Percentage
* Pass/Fail status
* Time taken

---

### **9. Result Screen**

After completing the examination, the result screen displays:

* Candidate name
* Total score
* Correct answers
* Incorrect answers
* Time taken
* Percentage
* Pass/Fail status

The passing percentage is:

```text
50%
```

A score of **50% or above** is displayed as:

```text
Status: Pass
```

A score below 50% is displayed as:

```text
Status: Fail
```

---

## **🏗️ Project Structure**

```text
OIBSIP_Java_Task4
│
├── Question.java
├── User.java
├── LoginFrame.java
├── ProfileFrame.java
├── ExamFrame.java
├── ResultFrame.java
└── OIBSIP_Java_Task4.java
```

---

## **📂 Class Description**

### **`Question.java`**

Represents an examination question.

It stores:

* Question text
* Four answer options
* Correct answer
* Selected answer

The class also provides functionality to determine whether the selected answer is correct.

Each question must contain exactly **4 options**.

---

### **`User.java`**

Represents the examination system user.

It stores:

* Username
* Password
* Display name

The class provides getter and setter methods for managing user information.

---

### **`LoginFrame.java`**

Provides the login interface.

Responsibilities include:

* Accepting username
* Accepting password
* Validating empty fields
* Verifying credentials
* Displaying login messages
* Opening the profile screen after successful login

---

### **`ProfileFrame.java`**

Provides the profile update interface.

Responsibilities include:

* Displaying the current display name
* Updating the display name
* Updating the password
* Validating the display name
* Opening the examination screen

---

### **`ExamFrame.java`**

Provides the main examination interface.

Responsibilities include:

* Displaying questions
* Displaying four answer options
* Storing selected answers
* Navigating between questions
* Managing the countdown timer
* Calculating the score
* Handling manual submission
* Handling automatic submission when time expires
* Handling examination window closing

---

### **`ResultFrame.java`**

Displays the final examination result.

It displays:

* Candidate name
* Score
* Correct answers
* Incorrect answers
* Time taken
* Percentage
* Pass/Fail status

---

### **`OIBSIP_Java_Task4.java`**

This is the main class of the application.

It contains the `main()` method and starts the application by creating the `LoginFrame`.

---

## **🔄 Application Flow**

```text
                 ┌──────────────────┐
                 │    LoginFrame    │
                 └────────┬─────────┘
                          │
                   Valid Credentials
                          │
                          ▼
                 ┌──────────────────┐
                 │   ProfileFrame   │
                 └────────┬─────────┘
                          │
                  Update Profile
                          │
                          ▼
                 ┌──────────────────┐
                 │    ExamFrame     │
                 └────────┬─────────┘
                          │
              ┌───────────┼───────────┐
              │           │           │
              ▼           ▼           ▼
          Previous       Next       Submit
              │           │           │
              └───────────┼───────────┘
                          │
                          ▼
                 ┌──────────────────┐
                 │   ResultFrame    │
                 └────────┬─────────┘
                          │
                          ▼
                         Exit
```

---

## **⏱️ Examination Configuration**

The current examination configuration is:

| Configuration        | Value              |
| -------------------- | ------------------ |
| Number of Questions  | 10                 |
| Options per Question | 4                  |
| Total Time           | 10 minutes         |
| Passing Percentage   | 50%                |
| Question Type        | Multiple Choice    |
| Navigation           | Previous / Next    |
| Submission           | Manual / Automatic |

---

## **🧪 Testing**

The application was tested for the following scenarios:

### **Login Testing**

* Valid username and password
* Invalid username
* Invalid password
* Empty username
* Empty password
* Enter key navigation and login

### **Profile Testing**

* Display name update
* Password update
* Updating both fields
* Empty display name validation
* Continuing to the examination

### **Examination Testing**

* Displaying questions
* Selecting answers
* Moving to the next question
* Moving to the previous question
* Preserving selected answers
* Timer countdown
* Manual submission
* Submission confirmation
* Automatic completion when time expires
* Examination window closing confirmation

### **Result Testing**

* Score calculation
* Correct answer count
* Incorrect answer count
* Percentage calculation
* Pass/Fail status
* Time taken calculation
* Candidate name display
* Exit functionality

---

## **🎨 GUI**

The application uses a clean desktop interface built with **Java Swing**.

The GUI uses a consistent color scheme with:

* Light gray backgrounds
* Blue headings
* Blue action buttons
* Dark gray labels
* Red timer display
* Green color for passing status
* Red color for failing status

The interfaces use **GridBagLayout** for arranging components.

---

## **🧩 Architecture**

The project is organized into separate classes based on their responsibilities:

```text
Main Class
    ↓
LoginFrame
    ↓
ProfileFrame
    ↓
ExamFrame
    ↓
ResultFrame
```

Supporting model classes:

```text
User
Question
```

This structure separates the application's data models from its graphical user interface and makes the project easier to understand, maintain, and extend.

---

## **▶️ How to Run**

### **Prerequisites**

Make sure the following are installed:

* Java JDK
* NetBeans IDE

### **Steps**

1. Clone or download the repository.

2. Open the project in NetBeans.

3. Make sure all Java files are placed in the same project/source package.

4. Clean and build the project.

5. Run:

```text
OIBSIP_Java_Task4.java
```

The application starts from the login screen.

---

## **🔑 Default Login Credentials**

The current application uses predefined credentials in `LoginFrame.java`.

```text
Username: mubashir
Password: 2006
```

These credentials are hardcoded in the application for demonstration purposes.

If the credentials are changed in `LoginFrame.java`, the new credentials should be used when logging in.

---

## **👨‍💻 Author**

**Mubashir Hussain**

BS Software Engineering Student

Developed as part of the **OIBSIP Java Programming Internship**.

---

## **📄 License**

This project was developed for educational and internship purposes.
