# **ATM Interface**

A console-based ATM Interface developed in Java using Object-Oriented Programming concepts. The application allows users to authenticate using a User ID and PIN and perform banking operations such as checking balance, withdrawing money, depositing money, transferring money, and viewing transaction history.

This project was developed as **Task 3** of the **OIBSIP Java Programming Internship**.

---

## **📌 Project Overview**

The ATM Interface is a console-based banking simulation designed to demonstrate core Java and Object-Oriented Programming concepts.

Users first authenticate themselves using their User ID and PIN. After successful authentication, they can access the ATM menu and perform different banking operations.

The application supports:

* User authentication
* Three login attempts
* Balance checking
* Cash withdrawal
* Cash deposit
* Money transfer
* Transaction history
* Input validation
* Multiple sample bank accounts
* Logout/quit functionality

All transactions performed during the current ATM session are stored using an `ArrayList`.

---

## **🎯 Objectives**

The main objectives of this project are:

* Build a console-based ATM simulation using Java
* Implement User ID and PIN authentication
* Limit unsuccessful login attempts to three
* Implement common ATM banking operations
* Validate transaction amounts
* Check sufficient balance before withdrawals and transfers
* Maintain transaction history using `ArrayList`
* Apply Object-Oriented Programming principles
* Use multiple classes to separate different responsibilities

---

## **🛠️ Technologies Used**

| Technology                  | Purpose                         |
| --------------------------- | ------------------------------- |
| Java                        | Application development         |
| `Scanner`                   | Console input                   |
| `ArrayList`                 | Account and transaction storage |
| Object-Oriented Programming | Application design              |
| NetBeans IDE                | Development environment         |

---

## **✨ Features**

### **1. User Authentication**

The application starts with an ATM login screen in the console.

The user enters:

* User ID
* PIN

The entered credentials are checked against the accounts stored in the `Bank` class.

If the credentials are correct, access is granted.

If the credentials are incorrect, the user receives another attempt.

The application allows a maximum of **3 login attempts**.

After three unsuccessful attempts, the application displays:

```text
Access Denied.
```

---

### **2. Sample Accounts**

The application contains three sample accounts:

| User ID  | Account ID | Initial Balance |
| -------- | ---------- | --------------: |
| Mubashir | ACC_101    |          300000 |
| Tajamil  | ACC_102    |           50000 |
| Muzammil | ACC_103    |          100000 |

These accounts are created when the `Bank` object is initialized.

The PINs are defined in the program as sample credentials for the educational ATM simulation.

---

### **3. ATM Menu**

After successful login, the following menu is displayed:

```text
===== ATM MENU =====
1. Check Balance
2. Withdraw
3. Deposit
4. Transfer
5. Transaction History
6. Quit
```

The user can select an operation by entering its corresponding number.

---

### **4. Check Balance**

The user can view the current balance of the authenticated account.

The balance is retrieved from the current `Account` object.

Example:

```text
Current Balance:300000.0
```

---

### **5. Withdraw**

The withdrawal feature allows the user to enter an amount.

The application checks that:

* The entered value is numeric
* The amount is greater than zero
* Sufficient balance is available

If the withdrawal is successful, the balance is updated and the transaction is added to the transaction history.

If the amount is invalid, the application displays:

```text
Invalid Amount.
```

If the balance is insufficient, it displays:

```text
Insufficient Funds.
```

---

### **6. Deposit**

The deposit feature allows the user to add money to the current account.

The application validates that the amount is greater than zero.

After a successful deposit:

* The account balance is increased
* A deposit transaction is recorded
* The updated balance is displayed

Example:

```text
Successfully Deposited.
Current Balance: 310000.0
```

---

### **7. Transfer**

The transfer feature allows the authenticated user to transfer money to another account.

The user enters:

* Recipient Account ID or User ID
* Transfer amount

The application checks:

* Whether the recipient account exists
* Whether the recipient is not the current user's own account
* Whether the amount is valid
* Whether sufficient funds are available

After a successful transfer:

* The sender's balance is decreased
* The recipient's balance is increased
* The transfer is added to transaction history

Example:

```text
Transfer Successful.
Current Balance:290000.0
```

---

### **8. Transaction History**

All successful transactions performed during the current ATM session are stored in an `ArrayList<Transaction>`.

The transaction history records:

* Transaction type
* Transaction amount
* Transaction details

Example:

```text
Withdraw : 5000.0 (Cash Withdrawal)
Deposit : 10000.0 (Cash Deposited)
Transfer : 2000.0 (Transferred to ACC_102)
```

If no transaction has been performed, the application displays:

```text
No Transaction History.
```

---

### **9. Input Validation**

The application performs validation for different types of input.

#### **Menu Validation**

If the user enters a non-numeric menu choice:

```text
Invalid input. Please enter a number.
```

#### **Withdrawal Validation**

The application validates numeric input and checks for:

* Invalid amounts
* Insufficient funds

#### **Deposit Validation**

The application checks that the entered deposit amount is valid and greater than zero.

#### **Transfer Validation**

The application checks:

* Recipient account existence
* Self-transfer prevention
* Numeric amount input
* Valid transaction amount
* Sufficient balance

---

## **📂 Class Description**

### **`Account`**

The `Account` class represents a bank account.

It contains private fields for:

* User ID
* PIN
* Account ID
* Balance

The class provides methods for:

* Getting account information
* Depositing money
* Withdrawing money

The balance is modified through the `deposit()` and `withdraw()` methods.

---

### **`Transaction`**

The `Transaction` class represents a banking transaction.

It contains:

* Transaction type
* Transaction amount
* Transaction details

The `toString()` method provides a readable representation of each transaction for the transaction history.

---

### **`Bank`**

The `Bank` class manages the accounts used by the ATM.

It stores accounts in an `ArrayList<Account>`.

It provides methods to:

* Authenticate users
* Find an account using Account ID or User ID

The class initializes three sample accounts when the application starts.

---

### **`ATM`**

The `ATM` class controls the main ATM operations.

It manages:

* User authentication
* Login attempts
* ATM menu
* Balance checking
* Withdrawals
* Deposits
* Transfers
* Transaction history
* Quit operation

The class maintains the currently authenticated account and stores transaction history in an `ArrayList<Transaction>`.

---

### **`OIBSIP_Java_Task3`**

The `OIBSIP_Java_Task3` class contains the `main()` method and serves as the entry point of the application.

It:

1. Creates a `Bank` object
2. Creates an `ATM` object
3. Starts the ATM application

```java
Bank bank = new Bank();
ATM atm = new ATM(bank);
atm.start();
```

---

## **📁 Project Structure**
```text
OIBSIP_Java_Task3
├── Account.java
├── Transaction.java
├── Bank.java
├── ATM.java
└── OIBSIP_Java_Task3.java
```
---

## **🔄 Application Flow**

```text
                  ┌──────────────────┐
                  │    Start ATM     │
                  └────────┬─────────┘
                           │
                           ▼
                  ┌──────────────────┐
                  │  User ID + PIN   │
                  └────────┬─────────┘
                           │
                    ┌──────┴──────┐
                    │             │
                 Valid         Invalid
                    │             │
                    ▼             ▼
              ATM Menu       Try Again
                    │             │
                    │       Maximum 3 Attempts
                    │             │
                    │             ▼
                    │       Access Denied
                    │
                    ▼
          ┌──────────────────────┐
          │    ATM Operations    │
          ├──────────────────────┤
          │ 1. Check Balance     │
          │ 2. Withdraw          │
          │ 3. Deposit           │
          │ 4. Transfer          │
          │ 5. Transaction Hist. │
          │ 6. Quit              │
          └──────────┬───────────┘
                     │
                     ▼
              Update Account
                     │
                     ▼
             Record Transaction
                     │
                     ▼
                Return Menu
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
OIBSIP_Java_Task3.java
```

4. Compile and run the program.

5. Enter one of the available sample User IDs and corresponding PIN.

6. After successful authentication, select an option from the ATM menu.

---

## **🧪 Testing**

The application was tested for the following scenarios:

### **Authentication Testing**

* Valid User ID and PIN
* Invalid User ID
* Invalid PIN
* Three unsuccessful login attempts
* Access denial after maximum attempts

### **Balance Testing**

* Viewing current account balance

### **Withdrawal Testing**

* Valid withdrawal
* Non-numeric amount
* Zero amount
* Negative amount
* Withdrawal greater than available balance
* Successful withdrawal

### **Deposit Testing**

* Valid deposit
* Non-numeric amount
* Zero amount
* Negative amount
* Successful deposit

### **Transfer Testing**

* Valid recipient account
* Invalid recipient account
* Transfer to own account
* Invalid transfer amount
* Transfer greater than available balance
* Successful transfer

### **Transaction History Testing**

* No transaction history
* Successful withdrawal recorded
* Successful deposit recorded
* Successful transfer recorded
* Displaying transaction history

### **Menu Testing**

* Valid menu options
* Invalid numeric option
* Non-numeric menu input
* Quit option

---

## **📚 Java Concepts Used**

This project demonstrates the following Java concepts:

* Classes and objects
* Encapsulation
* Private fields
* Constructors
* Methods
* Getters
* `ArrayList`
* `Scanner`
* `while` loops
* `do-while` loops
* `for-each` loops
* `switch-case`
* Conditional statements
* Input validation
* Object interaction
* Exception-safe input handling using `Scanner` validation

---

## **🔐 Encapsulation**

The `Account` class uses private fields to protect account information:

```java
private String userId;
private String pin;
private String accountId;
private double balance;
```

Account balance changes are performed through methods such as:

```java
deposit()
withdraw()
```

This demonstrates the use of encapsulation in Object-Oriented Programming.

---

## **👨‍💻 Author**

**Mubashir Hussain**

BS Software Engineering Student

Developed as part of the **OIBSIP Java Programming Internship**.

---

## **📄 License**

This project was developed for educational and internship purposes.
