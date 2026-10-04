class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);
    }

    void pop() {
        if (stack.isEmpty())
            return;

        int value = stack.pop();

        if (value == minStack.peek())
            minStack.pop();
    }

    int top() {
        if (stack.isEmpty())
            return -1;

        return stack.peek();
    }

    int getMin() {
        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }
}