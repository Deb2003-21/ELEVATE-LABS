
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
