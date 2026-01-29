import java.util.Stack;

class RemoveKAdjacentDuplicates {
    static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek()[0] != c) {
                stack.push(new int[] { c, 1 });
            } else {
                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();

            for (int i = 1; i <= top[1]; i++) {
                result.append((char) top[0]);
            }
        }

        return result.reverse().toString();
    }
}
