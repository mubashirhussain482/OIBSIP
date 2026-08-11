Online Reservation System

A GUI-based Online Reservation System developed in Java using Swing,
JDBC, and Oracle Database. The system allows users to log in, make train
reservations, view booking details using a PNR number, and cancel
reservations.

This project was developed as Task 1 of the OIBSIP Java Programming
Internship.

------------------------------------------------------------------------

📌 Project Overview

The Online Reservation System provides a simple graphical interface for
managing train reservations.

Users can:

-   Log in using valid credentials
-   Enter passenger and journey details
-   Select a train and class type
-   Automatically retrieve the train name using the train number
-   Book a reservation
-   Receive an automatically generated PNR number
-   View complete reservation details using the PNR
-   Cancel an existing reservation
-   Log out of the system

The application uses Oracle Database for storing and managing users,
trains, and reservations.

------------------------------------------------------------------------

🎯 Objectives

The main objectives of this project are:

-   Build a desktop-based reservation system using Java Swing
-   Connect Java with Oracle Database using JDBC
-   Implement database operations using DAO classes
-   Apply object-oriented programming principles
-   Provide input validation through a graphical interface
-   Generate unique PNR numbers for reservations
-   Implement booking and cancellation functionality
-   Separate the application into GUI, model, DAO, and database layers

------------------------------------------------------------------------

🛠️ Technologies Used

  Technology            Purpose
  --------------------- ---------------------------------
  Java                  Application development
  Java Swing            Graphical User Interface
  JDBC                  Database connectivity
  Oracle Database 19c   Data storage
  NetBeans IDE          Development environment
  OJDBC Driver          Oracle-Java database connection

------------------------------------------------------------------------

✨ Features

1. User Login

The system provides a login form with:

-   Username field
-   Password field
-   Empty-field validation
-   Database-based credential verification
-   Invalid credential error message

Only valid users stored in the Oracle database can access the
reservation system.

------------------------------------------------------------------------

2. Train Reservation

The reservation form contains:

-   Passenger Name
-   Train Number
-   Train Name
-   Class Type
-   Journey Date
-   Source Station
-   Destination Station

The train name is automatically retrieved from the database after
entering a valid train number.

------------------------------------------------------------------------

3. Train Number Validation

The system checks that:

-   Train number is not empty
-   Train number contains numeric input
-   The train exists in the database

If the train number is invalid or does not exist, an appropriate error
message is displayed.

------------------------------------------------------------------------

4. Automatic Train Name Retrieval

When a valid train number is entered, the system retrieves the
corresponding train name from the Oracle database.

For example:

    Train Number: 1001
    Train Name: Green Express

The train name field is automatically populated and cannot be manually
edited.

------------------------------------------------------------------------

5. Booking Reservation

After successful validation, the reservation is stored in the Oracle
database.

The system generates a unique PNR number for the reservation.

A confirmation dialog displays the booking details, including:

-   PNR
-   Passenger name
-   Train name
-   Class type
-   Journey date
-   Source
-   Destination

------------------------------------------------------------------------

6. Reservation Cancellation

The cancellation form allows the user to enter a PNR number.

The system:

1.  Validates the PNR
2.  Searches the database
3.  Retrieves the complete reservation
4.  Displays the booking details
5.  Asks for cancellation confirmation
6.  Deletes the reservation after confirmation

The user must confirm the cancellation before the reservation is removed
from the database.

------------------------------------------------------------------------

7. Input Validation

The system performs basic validation for:

-   Empty username
-   Empty password
-   Empty passenger name
-   Empty train number
-   Non-numeric train number
-   Invalid/non-existing train number
-   Empty journey date
-   Invalid date format
-   Empty source station
-   Empty destination station
-   Same source and destination
-   Empty/non-numeric PNR

------------------------------------------------------------------------

🏗️ Project Structure

    OIBSIP_Java_Task1
    │
    ├── database
    │   └── DBConnection.java
    │
    ├── model
    │   ├── User.java
    │   └── Reservation.java
    │
    ├── dao
    │   ├── UserDAO.java
    │   └── ReservationDAO.java
    │
    └── gui
        ├── LoginFrame.java
        ├── ReservationFrame.java
        └── CancellationFrame.java

------------------------------------------------------------------------

📂 Package Description

database

Contains the database connection class.

DBConnection.java

Responsible for establishing a JDBC connection between the Java
application and Oracle Database.

------------------------------------------------------------------------

model

Contains the data model classes.

User.java

Represents a system user and contains:

-   Username
-   Password

Reservation.java

Represents a train reservation and contains:

-   PNR
-   Passenger name
-   Train number
-   Train name
-   Class type
-   Journey date
-   Source station
-   Destination station

------------------------------------------------------------------------

dao

Contains classes responsible for database operations.

UserDAO.java

Handles user authentication by checking the entered username and
password against the database.

ReservationDAO.java

Handles reservation-related database operations such as:

-   Retrieving train name
-   Booking a reservation
-   Retrieving reservation details
-   Cancelling a reservation

------------------------------------------------------------------------

gui

Contains the Java Swing graphical user interface.

LoginFrame.java

Provides the login interface and authenticates users through UserDAO.

ReservationFrame.java

Provides the reservation form and handles booking operations.

CancellationFrame.java

Provides the cancellation form and handles reservation lookup and
cancellation.

------------------------------------------------------------------------

🗄️ Database

The application uses Oracle Database 19c.

The database contains tables for managing:

-   Users
-   Trains
-   Reservations

The Java application communicates with Oracle using JDBC and the Oracle
JDBC driver.

------------------------------------------------------------------------

🔌 Database Connection

The project uses an Oracle JDBC connection similar to:

    DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:orcl",
        "username",
        "password"
    );

The actual database credentials should be configured locally and should
not be uploaded to GitHub.

------------------------------------------------------------------------

🔄 Application Flow

                        ┌───────────────┐
                        │   LoginFrame  │
                        └───────┬───────┘
                                │
                         Valid Credentials
                                │
                                ▼
                    ┌──────────────────────┐
                    │   ReservationFrame   │
                    └───────┬──────────────┘
                            │
                  ┌─────────┴─────────┐
                  │                   │
                  ▼                   ▼
           Book Reservation    Cancel Reservation
                  │                   │
                  ▼                   ▼
               Oracle          CancellationFrame
                                      │
                                      ▼
                                Enter PNR
                                      │
                                      ▼
                              Fetch Reservation
                                      │
                                      ▼
                           Confirm Cancellation
                                      │
                                      ▼
                                   Oracle

------------------------------------------------------------------------

🔐 Security Note

Database credentials are required for the application to connect to
Oracle.

For security reasons, database usernames and passwords should not be
committed to a public GitHub repository.

Before uploading the project, replace any personal database credentials
with placeholders or use a separate configuration method.

------------------------------------------------------------------------

▶️ How to Run

Prerequisites

Make sure the following are installed:

-   Java JDK
-   NetBeans IDE
-   Oracle Database 19c
-   Oracle JDBC driver (ojdbc)
-   An Oracle database service such as ORCL

Steps

1.  Clone or download the repository.

2.  Open the project in NetBeans.

3.  Make sure Oracle Database 19c is running.

4.  Create the required database tables and sequence in Oracle.

5.  Configure the database connection in:

    database/DBConnection.java

6.  Add the Oracle JDBC driver to the project’s libraries.

7.  Clean and build the project.

8.  Run:

    LoginFrame.java

The application starts from the login screen.

------------------------------------------------------------------------

🧪 Testing

The application was tested for the following scenarios:

Login Testing

-   Valid username and password
-   Invalid username
-   Invalid password
-   Empty username
-   Empty password

Reservation Testing

-   Valid reservation
-   Empty required fields
-   Non-numeric train number
-   Non-existing train number
-   Automatic train name retrieval
-   Invalid date format
-   Same source and destination
-   Successful PNR generation
-   Database insertion

Cancellation Testing

-   Empty PNR
-   Non-numeric PNR
-   Non-existing PNR
-   Fetching valid reservation
-   Displaying complete booking details
-   Cancellation confirmation
-   Successful deletion from database

------------------------------------------------------------------------

🎨 GUI

The application uses a clean desktop interface built with Java Swing.

The GUI uses a consistent professional color scheme with:

-   Warm off-white backgrounds
-   Dark charcoal headings
-   Deep green booking actions
-   Teal actions for data retrieval
-   Dark red for cancellation actions
-   Gray for secondary actions

------------------------------------------------------------------------

🧩 Architecture

The project follows a layered structure:

    GUI Layer
        ↓
    DAO Layer
        ↓
    JDBC / Database Connection
        ↓
    Oracle Database

The model classes are used to represent application data.

This separation makes the project easier to understand, maintain, and
extend.

------------------------------------------------------------------------

👨‍💻 Author

Mubashir Hussain

BS Software Engineering Student

Developed as part of the OIBSIP Java Programming Internship.

------------------------------------------------------------------------

📄 License

This project was developed for educational and internship purposes
