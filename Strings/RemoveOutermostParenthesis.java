import java.util.Stack;

public class RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String str = "(()()) (())";

        // // Approach 1 ---
        // Stack<Character> stack = new Stack<>();
        // StringBuilder result = new StringBuilder();

        // for (int i = 0; i <= str.length() - 1; i++) {
        // if (str.charAt(i) == '(') {
        // stack.push(str.charAt(i));
        // } else if (str.charAt(i) == ')') {
        // char c = stack.pop().charValue();

        // if (stack.size() > 0) {
        // result.append(c);
        // result.append(str.charAt(i));
        // }
        // } else {
        // result.append(str.charAt(i));
        // }
        // }

        // System.out.println(result);

        // Approach 2 ---
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i <= str.length() - 1; i++) {

            if (str.charAt(i) == '(') {
                count++;

                if (count > 1) {
                    result.append(str.charAt(i));
                }
            } else if (str.charAt(i) == ')') {
                count--;

                if (count > 0) {
                    result.append(str.charAt(i));
                }
            } else {
                result.append(str.charAt(i));
            }
        }

        System.out.println(result);
    }
}