class LongestSubstringWithoutRepeatingCharacters {
    int lengthOfLongestSubstring(String text) {
        int maxLength = 0;

        for (int i = 0; i < text.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < text.length(); j++) {
                char c = text.charAt(j);

                if (!set.contains(c))
                    set.add(c);
                else
                    break;
            }

            maxLength = Math.max(maxLength, set.size());
        }

        return maxLength;
    }

    int lengthOfLongestSubstring2(String text) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();

        while (end < text.length()) {
            char c = text.charAt(end);

            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, set.size());
                end++;
            } else {
                while (set.contains(c)) {
                    set.remove(text.charAt(start));
                    start++;
                }
            }
        }

        return maxLength;
    }
}