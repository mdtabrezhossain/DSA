import java.util.HashSet;

class LongestSubstringWithUniqueCharacters {
    int lengthOfLongestSubstring(String string) {
        int maxLength = 0;

        for (int i = 0; i <= string.length() - 1; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = i; j <= string.length() - 1; j++) {
                char letter = string.charAt(j);

                if (set.contains(letter)) {
                    break;
                } else {
                    set.add(letter);
                }
            }

            int length = set.size();
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    int lengthOfLongestSubstring2(String string) {
        int maxLength = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();

        while (j <= string.length() - 1) {
            char letter = string.charAt(j);

            if (!set.contains(letter)) {
                set.add(letter);
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
                j++;
            } else {
                set.remove(string.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}
