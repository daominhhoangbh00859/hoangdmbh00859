class StudentStack {
    private Student[] stack;
    private int top;
    private int capacity;

    public StudentStack(int capacity) {
        this.capacity = capacity;
        stack = new Student[capacity];
        top = -1;
    }


    public void push(Student student) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot push student.");
            return;
        }
        stack[++top] = student;
    }


    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop student.");
            return null;
        }
        return stack[top--];
    }


    public Student top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top student.");
            return null;
        }
        return stack[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public int size() {
        return top + 1;
    }


    public Student peek() {
        return top();
    }
}