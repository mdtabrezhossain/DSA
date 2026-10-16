class PalindromePartitioning {
    List<List<String>> result;
    List<String> parts;

    List<List<String>> partition(String text) {
        result = new ArrayList<>();
        parts = new ArrayList<>();

        helper(text, 0);

        return result;
    }

    void helper(String text, int start) {
        if (start == text.length()) {
            result.add(new ArrayList<>(parts));
            return;
        }

        for (int i = start; i < text.length(); i++) {
            String part = text.substring(start, i + 1);

            if (isPalindrome(part)) {
                parts.add(part);

                helper(text, i + 1);

                parts.remove(parts.size() - 1);
            }
        }
    }

    boolean isPalindrome(String text) {
        int i = 0;
        int j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}