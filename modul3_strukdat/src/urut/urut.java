package urut;

public class urut {

    private static class Stack {
        private char[] items;
        private int top;

        public Stack(int size) {
            items = new char[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == items.length - 1;
        }

        public void push(char item) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            items[++top] = item;
        }

        public char pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return items[top--];
        }
    }

    public static String reverseString(String input) {
        Stack stack = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String inputString = "Hello World!";
        String reversedString = reverseString(inputString);
        System.out.println("String terbalik: " + reversedString);
    }
}
