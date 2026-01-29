import java.util.Stack;

class NextGreaterElementInCircularArray {
    static int[] nextGreaterElements(int[] array) {
        int[] result = new int[array.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = array.length - 2; i >= 0; i--) {
            stack.push(array[i]);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && array[i] >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return result;
    }
}