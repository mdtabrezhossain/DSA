import java.util.Stack;

class MaximumNestingParenthesisDepth {
    public static void main(String[] args) {
        String str = "()(())((()()))";
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        System.out.println("Maximum level of parenthesis nesting: " + maxDepth);
    }
}