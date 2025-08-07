import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Abstract class for issuing books
abstract class issue {
    abstract void issueBook(String userId, String bookTitle);

    abstract void viewIssuedBooks(String userId);
}

// Class representing a user in the library system
class user {
    private String name;
    private String userId;
    private List<user> users = new ArrayList<>();

    public user() {
        // Default constructor
    }

    public user(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    void addUser(String name, String userId) {
        // Logic to add a user
        user newUser = new user(name, userId);
        users.add(newUser);
        System.out.println("User added: " + name);
    }

    void showUsers() {
        // Logic to show all users
        for (user u : users) {
            System.out.println("User: " + u.getName() + ", ID: " + u.getUserId());
        }
    }
}

// Class representing a book in the library
class book {
    private String title;
    private String author;

    public book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Class representing a library, extending the book class
class library extends book {
    public library() {
        super("Default Title", "Default Author");
    }

    private String location;
    private List<book> books = new ArrayList<>();
    private List<ArrayList<String>> issuedBooks = new ArrayList<>();

    public library(String title, String author, String location) {
        super(title, author);
        this.location = location != null && !location.isEmpty() ? location : "kolkata";
    }

    public String getLocation() {
        return location;
    }

    // Method to add a book to the library
    public void addBook(String title, String author) {
        // Logic to add a book to the library
        book newBook = new book(title, author);
        books.add(newBook);
        System.out.println("Book added: " + title);

    }

    // Method to view all books in the library
    void viewIssuedBooks(String userId) {
        for (ArrayList<String> entry : issuedBooks) {
            if (entry.get(0).equals(userId)) {
                System.out.println("Issued Book: " + entry.get(1));
            }
        }
    }

    // Method to issue a book to a user
    void issueBook(String userId, String bookTitle) {
        issuedBooks.add(new ArrayList<>(Arrays.asList(userId, bookTitle)));
    }

}

// Main class to run the Mini Library application
class MiniLibraryMain {
    public static void main(String[] args) {
        user u = new user();
        u.addUser("Alice", "U001");
        u.addUser("Bob", "U002");
        u.showUsers();

        library lib = new library();
        lib.addBook("Effective Java", "Joshua Bloch");
        lib.addBook("Clean Code", "Robert C. Martin");

        lib.issueBook("U001", "Effective Java");
        lib.issueBook("U001", "Clean Code");
        lib.viewIssuedBooks("U001");

    }
}
