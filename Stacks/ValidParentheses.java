import java.util.Stack;

class ValidParentheses {
    static boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();

        for (char c : string.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
