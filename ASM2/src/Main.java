import java.util.Random;
import java.util.Scanner;

public class Main {
    private static StudentStack stack = new StudentStack();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Generate Test Data");
            System.out.println("3. Display Students");
            System.out.println("4. Compare Sort Algorithms");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    stack.push(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter the number of students to generate: ");
                    int numberOfStudents = scanner.nextInt();
                    generateTestData(numberOfStudents);
                    break;
                case 3:
                    stack.displayStudents();
                    break;
                case 4:
                    compareSortAlgorithms();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void generateTestData(int count) {
        String[] sampleNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah"};
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String id = "S" + (1000 + i);
            String name = sampleNames[random.nextInt(sampleNames.length)] + i;
            double marks = 1 + (random.nextDouble() * 9); // Random marks between 1 and 10
            stack.push(new Student(id, name, marks));
        }
        System.out.println(count + " students generated!");
    }

    public static void compareSortAlgorithms() {
        System.out.print("Enter the number of students to test sorting algorithms: ");
        int numberOfStudents = new Scanner(System.in).nextInt();
        generateTestData(numberOfStudents); // Generate test data

        // Sort using Bubble Sort
        long bubbleStartTime = System.nanoTime();
        stack.bubbleSort();
        long bubbleEndTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (bubbleEndTime - bubbleStartTime) + " nanoseconds");

        // Regenerate test data for Quick Sort
        stack = new StudentStack(); // Reset the stack
        generateTestData(numberOfStudents); // Generate fresh data again

        // Sort using Quick Sort
        long quickStartTime = System.nanoTime();
        stack.quickSort();
        long quickEndTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (quickEndTime - quickStartTime) + " nanoseconds");
    }
}