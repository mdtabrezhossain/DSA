class LetterCombinationsOfAPhoneNumber {
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    StringBuilder combination;
    List<String> result;

    List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        result = new ArrayList<>();
        combination = new StringBuilder();

        helper(digits, 0);

        return result;
    }

    void helper(String digits, int idx) {
        if (idx == digits.length()) {
            result.add(combination.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));

            helper(digits, idx + 1);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
