import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

// Notes class to represent a note
class notes {
    private String title;
    private String content;

    public notes() {
        // Default constructor
    }

    // Constructor to initialize title and content
    public notes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Method to read from a file
    // and write the note to it
    public void file_read() {

        try (FileReader fr = new FileReader("notes.txt")) {
            char[] arr = new char[1024];
            int bytesRead = fr.read(arr);
            String data = new String(arr, 0, bytesRead);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to write the note to a file
    // If the file does not exist, it will be created
    public void file_write() {

        try (FileWriter fr = new FileWriter("notes.txt", true)) {
            fr.write("Title: " + getTitle() + "\n");
            fr.write("Content: " + getContent() + "\n");
            fr.write("-------------------------\n");
            System.out.println("Note saved successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        System.err.println("Enter the title of the note:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.err.println("Enter the content of the note:");
        String content = scanner.nextLine();
        notes note = new notes();
        note.setTitle(title);
        note.setContent(content);
        note.file_write();
        System.err.println("Reading the notes from the file:");
        note.file_read();
        scanner.close();
    }
}