public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng stack với dung lượng 5
        Stack stack = new Stack(5);

        // Thực hiện các thao tác push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Thử đẩy phần tử khi stack đầy
        stack.push(60);

        // In ra phần tử ở đỉnh của stack
        System.out.println("Peek: " + stack.peek());

        // Thực hiện pop
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        // In ra phần tử ở đỉnh của stack sau khi pop
        System.out.println("Peek after pops: " + stack.peek());
    }

    // Stack class (dùng mảng)
    static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int value) {
            if (top == maxSize - 1) {
                System.out.println("Stack is full. Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1;
            }
            return stackArray[top--];
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1;
            }
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
}
