class Solution {
    boolean isValid(String input) {
        StringBuilder temp = new StringBuilder(input);
        int i = 0;

        while (i < temp.length() - 1) {
            char c1 = temp.charAt(i);
            char c2 = temp.charAt(i + 1);

            if ((c1 == '(' && c2 == ')')
                    || (c1 == '[' && c2 == ']')
                    || (c1 == '{' && c2 == '}')) {
                temp.delete(i, i + 2);

                if (i > 0)
                    i--;
            } else
                i++;
        }

        return temp.length() == 0;
    }

    boolean isValid2(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((top == '(' && c != ')')
                        || (top == '[' && c != ']')
                        || (top == '{' && c != '}'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}