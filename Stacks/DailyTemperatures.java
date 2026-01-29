import java.util.Stack;

class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length - 1);

        for (int i = temperatures.length - 2; i >= 0; i--) {
            while (!stack.isEmpty()
                    && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}