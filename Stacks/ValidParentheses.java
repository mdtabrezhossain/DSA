class ValidParentheses {
    boolean isValid(String s) {
        StringBuilder temp = new StringBuilder(s);
        boolean isPairRemoved = true;

        while (isPairRemoved) {
            isPairRemoved = false;

            for (int i = 0; i < temp.length() - 1; i++) {
                char c1 = temp.charAt(i);
                char c2 = temp.charAt(i + 1);

                if ((c1 == '(' && c2 == ')')
                        || (c1 == '[' && c2 == ']')
                        || (c1 == '{' && c2 == '}')) {
                    temp.delete(i, i + 2);
                    isPairRemoved = true;
                    break;
                }
            }
        }

        return temp.length() == 0;
    }

    boolean isValid2(String string) {
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
