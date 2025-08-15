
# Task 1: Simple Calculator in Java

This is a simple command-line calculator program written in Java. It supports basic arithmetic operations and includes error handling for invalid inputs.

## Features

- Addition, subtraction, multiplication, and division
- Handles invalid number and operator inputs
- Prevents division by zero

# Task 2: CRUD Operation in Java (OOP)

This task demonstrates a basic CRUD (Create, Read, Update, Delete) application written in Java, applying object-oriented programming principles.

## Features

- Create, read, update, and delete entities (e.g., name, marks, etc.) using Java classes and objects
- Encapsulates data and operations using classes and methods
- Demonstrates use of constructors, getters, setters, and collection classes (e.g., ArrayList)
- Includes error handling for invalid operations (e.g., updating non-existent items)
- Well-structured and modular code for ease of extension


# Task 3: Mini Library System

This repository contains a simple Java-based Mini Library System designed to manage users, books, and their issuance. The application provides basic functionalities such as adding users, adding books, issuing books to users, and viewing issued books.

## Features

- **User Management**: Add users to the library system and display all registered users.
- **Book Management**: Add books to the library and list available books.
- **Book Issuance**: Issue books to users and view the books issued to a particular user.
- **Extensible Design**: Uses abstract classes for issuing books, allowing for future enhancements.

## Program Structure

- **issue (abstract class)**: Declares methods for issuing books and viewing issued books.
- **user (class)**: Manages user details and user list. Methods to add and display users.
- **book (class)**: Represents a book with title and author.
- **library (class)**: Extends the `book` class, manages library location, books, and book issuance records.
- **MiniLibraryMain (main class)**: Entry point; demonstrates usage of the library system.

### Features
- Add users to the system and display all users.
- Add books to the library.
- Issue books to users and view issued books for a user.
- Abstract class for extensibility in issuing books.

### Program Flow

- Users are created and added to an internal list.
- Books are added to the library.
- Books can be issued to users by their user ID.
- The system can display all books issued to a particular user.

 
# Task 4: Notes Application

This is a simple Java console application for managing notes. Notes can be written to a file and read back from it, enabling persistent storage between runs.

## Features

- Create a note with a title and content.
- Save notes to a file (`notes.txt`). Each note is appended to the file.
- Read and display all notes from the file.

# Task 5: Bank Account Example in Java

This project demonstrates a simple bank account implementation in Java using interfaces and classes. It provides basic operations such as depositing, withdrawing, checking the balance, and viewing transaction history.

## Features

- **Interface (`account`)**: Defines the basic operations for a bank account.
  - `deposit(double amount)`: Deposit money into the account.
  - `withdraw(double amount)`: Withdraw money from the account.
  - `getBalance()`: Get the current balance of the account.

- **Class (`bank`)**: Implements the `account` interface.
  - Stores account number and balance.
  - Maintains a transaction history.
  - Provides methods to perform deposit, withdrawal, and retrieve transaction history.

## Usage

The main method demonstrates the following:

1. Creating a new bank account with an initial balance.
2. Performing deposit and withdrawal operations.
3. Printing the transaction history.
4. Displaying the current balance.

# TASK 6: JFrame Todo App

A simple Todo List application built using Java Swing. This project demonstrates basic usage of `JFrame`, `JList`, and action listeners for adding and removing tasks.

## Features

- Add new tasks to your todo list.
- Remove selected tasks from the list.
- Scrollable list view for easy navigation.

## How It Works

- Enter a task in the text field.
- Click **Add** to add the task to the list.
- Select a task and click **Remove** to delete it from the list.

# TASK 7: Employee Database App

This project contains a Java program for basic CRUD (Create, Read, Update, Delete) operations on a MariaDB/MySQL database using JDBC.

## Overview

- Add a new employee record
- Display all employee records
- Update an employee record by ID
- Delete an employee record by ID

## Features

- **Database Connection:** Connects to a MariaDB/MySQL database using JDBC.
- **Adding Data:** Prompts the user for employee details (ID, name, salary) and inserts them into the database.
- **Viewing Data:** Displays all records from the `emp` table.
- **Updating Data:** Allows the user to update the name and salary of an employee by their ID.
- **Deleting Data:** Allows the user to delete an employee record by ID.
- **Error Handling:** Basic error messages are printed to the console if operations fail.

## Database Setup

- **Default Connection URL:** `jdbc:mariadb://localhost:3306/db1`
- **Default User:** `root`
- **Default Password:** `hatua`
- **Table:** Assumes the existence of a table named `emp` with columns `id`, `name`, `salary`.

# TASK 8: QuizApp

A simple Java console-based Quiz Application.

## Overview

This project is a command-line quiz application written in Java. Users are presented with multiple-choice questions and must select the correct answer by entering the corresponding number. The application keeps track of the user's score and displays it at the end of the quiz.

## Features

- Presents a series of multiple-choice questions.
- Accepts user input for answers.
- Checks and displays whether the answer is correct or wrong.
- Shows the correct answer for each question if the user's choice is wrong.
- Displays the final score at the end.

## How It Works

1. The quiz contains a predefined list of questions, each with four options.
2. For each question:
    - The question and its options are displayed.
    - The user is prompted to enter their answer (1-4).
    - The application checks if the answer is correct and updates the score.
    - Feedback is given after each question.
3. After all questions, the final score is displayed.

