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

            if (set.contains(c))
                while (set.contains(c)) {
                    set.remove(text.charAt(start));
                    start++;
                }

            set.add(c);
            maxLength = Math.max(maxLength, set.size());

            end++;
        }

        return maxLength;
    }

    int lengthOfLongestSubstring3(String text) {
        int maxLength = 0;

        int start = 0;
        int end = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (end < text.length()) {
            char c = text.charAt(end);

            if (map.containsKey(c)) {
                start = map.get(c) + 1;

                for (int i = start; i < map.get(c); i++)
                    map.remove(text.charAt(i));
            }

            map.put(c, end);
            maxLength = Math.max(maxLength, map.size());

            end++;
        }

        return maxLength;
    }
}