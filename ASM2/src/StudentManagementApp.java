
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);


        manager.initializeStudents();

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Search Student");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> manager.editStudent();
                case 3 -> manager.deleteStudent();
                case 4 -> manager.sortStudents();
                case 5 -> manager.searchStudent();
                case 6 -> manager.displayAllStudents();
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
