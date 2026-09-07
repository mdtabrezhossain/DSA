class GenerateParentheses {
    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, new StringBuilder(), n, result);
        return result;
    }

    void helper(int openCount, int closeCount, StringBuilder combination, int n, List<String> result) {
        if (combination.length() == 2 * n) {
            result.add(combination.toString());
            return;
        }

        if (openCount < n) {
            combination.append("(");
            helper(openCount + 1, closeCount, combination, n, result);

            combination.deleteCharAt(combination.length() - 1);
        }

        if (closeCount < openCount) {
            combination.append(")");
            helper(openCount, closeCount + 1, combination, n, result);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}