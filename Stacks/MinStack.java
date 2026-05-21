class MinStack {
    private Stack<Integer> stack;

    public MinStack1() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Stack<Integer> helperStack = new Stack<>();
        int value = stack.pop();
        int minimumValue = value;
        helperStack.push(value);

        while (!stack.isEmpty()) {
            value = stack.pop();
            minimumValue = Math.min(minimumValue, value);
            helperStack.push(value);
        }

        while (!helperStack.isEmpty()) {
            value = helperStack.pop();
            stack.push(value);
        }

        return minimumValue;
    }
}

class MinStack2 {
    private Stack<int[]> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int value) {
        if (!stack.isEmpty()) {
            int previousMinimumValue = stack.peek()[1];
            int currentMinimumValue = Math.min(previousMinimumValue, value);

            stack.push(new int[] { value, currentMinimumValue });
            return;
        }

        stack.push(new int[] { value, value });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}