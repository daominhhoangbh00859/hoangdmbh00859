import java.util.Scanner;

public class StudentStack {
    private Node top;
    private int size;

    public StudentStack() {
        top = null;
        size = 0;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        size--;
        return poppedStudent;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        System.out.println("Students in Stack:");
        Node current = top;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    public Student[] toArray() {
        Student[] students = new Student[size];
        Node current = top;
        int index = 0;
        while (current != null) {
            students[index++] = current.student;
            current = current.next;
        }
        return students;
    }

    public void bubbleSort() {
        Student[] students = toArray();
        int n = students.length;
        long startTime = System.nanoTime(); // Bắt đầu đo thời gian

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    // Swap
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime(); // Kết thúc đo thời gian
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " nanoseconds");

        // Rebuild the stack with sorted students
        top = null;
        size = 0;
        for (Student student : students) {
            push(student);
        }
    }

    public void quickSort() {
        Student[] students = toArray();
        long startTime = System.nanoTime(); // Bắt đầu đo thời gian

        quickSortHelper(students, 0, size - 1);

        long endTime = System.nanoTime(); // Kết thúc đo thời gian
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " nanoseconds");

        // Rebuild the stack with sorted students
        top = null;
        size = 0;
        for (Student student : students) {
            push(student);
        }
    }

    private void quickSortHelper(Student[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            quickSortHelper(students, low, pi - 1);
            quickSortHelper(students, pi + 1, high);
        }
    }

    private int partition(Student[] students, int low, int high) {
        double pivot = students[high].getMarks();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (students[j].getMarks() <= pivot) {
                i++;
                // Swap
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        // Swap pivot
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }
}