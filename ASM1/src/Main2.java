public class Main2 {
    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();


        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);


        System.out.println("Peek: " + stack.peek());


        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());


        System.out.println("Peek after pops: " + stack.peek());
    }


    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static class LinkedListStack {
        private Node top;

        public LinkedListStack() {
            top = null;
        }

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1;
            }
            int value = top.data;
            top = top.next;
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1;
            }
            return top.data;
        }

        public boolean isEmpty() {
            return (top == null);
        }
    }
}
