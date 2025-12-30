import java.util.Stack;

class MaximumNestingParenthesisDepth {
    public static void main(String[] args) {
        String str = "()(())((()()))";
        int maxDepth = 0;
        int currentDepth = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
                stack.push('(');
            } else if (c == ')') {
                currentDepth--;
                stack.pop();
            }
        }

        System.out.println("Maximum level of parenthesis nesting: " + maxDepth);
    }
}