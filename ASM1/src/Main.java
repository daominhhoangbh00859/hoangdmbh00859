public class Main {
    public static void main(String[] args) {
        StudentStack stack = new StudentStack(5);


        stack.push(new Student("S01", "Alice", 8.0));
        stack.push(new Student("S02", "Bob", 6.4));
        stack.push(new Student("S03", "Charlie", 9.2));


        System.out.println("Top student: " + stack.top());


        System.out.println("Popped student: " + stack.pop());
        System.out.println("New top student: " + stack.top());


        while (!stack.isEmpty()) {
            System.out.println("Popped student: " + stack.pop());
        }


        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}