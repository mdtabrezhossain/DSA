import java.util.Stack;

class StackReverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.print("Original Stack: ");
        for (int element : stack) {
            System.out.print(element + " ");
        }

        // // Approach 1 ---
        // Stack<Integer> reversedStack = new Stack<>();
        // reverse1(stack, reversedStack);

        // System.out.print("\n Reversed Stack: ");
        // for (int element : reversedStack) {
        // System.out.print(element + " ");
        // }

        // Approach 2 ---
        reverse2(stack);

        System.out.print("\n Reversed Stack: ");
        for (int element : stack) {
            System.out.print(element + " ");
        }
    }

    static void reverse1(Stack<Integer> stack, Stack<Integer> reversedStack) {
        if (stack.isEmpty()) {
            return;
        }

        reversedStack.push(stack.pop());
        reverse1(stack, reversedStack);
    }

    static void reverse2(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse2(stack);
        insertAtBottom(stack, top);
    }

    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }
}
