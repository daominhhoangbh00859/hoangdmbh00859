
import java.util.*;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);


    public void initializeStudents() {
        students.add(new Student("001", "Alice", 8.5));
        students.add(new Student("002", "Bob", 6.0));
        students.add(new Student("003", "Charlie", 9.2));
        students.add(new Student("004", "David", 4.8));
        students.add(new Student("005", "Eve", 7.0));
        students.add(new Student("006", "Frank", 5.5));
        System.out.println("Sample students have been initialized!");
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public void editStudent() {
        System.out.print("Enter the ID of the student to edit: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) student.setName(name);

            System.out.print("Enter new marks (leave blank to keep current): ");
            String marksInput = scanner.nextLine();
            if (!marksInput.isBlank()) student.setMarks(Double.parseDouble(marksInput));

            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks in descending order!");
    }

    public void searchStudent() {
        System.out.print("Enter the ID of the student to search: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display!");
        } else {
            students.forEach(System.out::println);
        }
    }

    private Student findStudentById(String id) {
        return students.stream().filter(student -> student.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}
