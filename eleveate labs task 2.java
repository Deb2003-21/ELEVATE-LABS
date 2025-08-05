import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Curd {

    private String name;
    private int id;
    private float marks;

    // Static list to hold all records (shared among all objects)
    private static List<Curd> recordList = new ArrayList<>();

    // Constructor
    public Curd(String name, int id, float marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    // Create method
    public static void create(String name, int id, float marks) {
        recordList.add(new Curd(name, id, marks));
        System.out.println("Record created successfully!");
    }

    // Read all records
    public static void getRecords() {
        if (recordList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Curd record : recordList) {
                System.out.println("Name: " + record.name + ", ID: " + record.id + ", Marks: " + record.marks);
            }
        }
    }

    // Read by ID
    public static String read(int id) {
        for (Curd record : recordList) {
            if (record.id == id) {
                return "Name: " + record.name + ", ID: " + record.id + ", Marks: " + record.marks;
            }
        }
        return "Record not found.";
    }

    // Update by ID
    public static void update(int id, String newName, float newMarks) {
        for (Curd record : recordList) {
            if (record.id == id) {
                record.name = newName;
                record.marks = newMarks;
                System.out.println("Record updated successfully!");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    // Delete by ID
    public static void delete(int id) {
        for (int i = 0; i < recordList.size(); i++) {
            if (recordList.get(i).id == id) {
                recordList.remove(i);
                System.out.println("Record deleted successfully!");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create");
            System.out.println("2. Read by ID");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Marks: ");
                    float marks = scanner.nextFloat();
                    create(name, id, marks);
                    break;

                case 2:
                    System.out.print("Enter ID to read: ");
                    int readId = scanner.nextInt();
                    System.out.println(read(readId));
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new marks: ");
                    float newMarks = scanner.nextFloat();
                    update(updateId, newName, newMarks);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    delete(deleteId);
                    break;

                case 5:
                    getRecords();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        scanner.close();
    }
}
