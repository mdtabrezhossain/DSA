class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(
                "Length of longest substring containing all same characters after replacing atmost K characters: "
                        + characterReplacement(s, k));
        // Output: 4
    }

    static int characterReplacement(String string, int replacementsAllowed) {
        int longestSubStringLength = 0;

        for (int i = 0; i <= string.length() - 1; i++) {
            int[] charCounts = new int[26];
            int maxCharCount = 0;

            for (int j = i; j <= string.length() - 1; j++) {
                charCounts[string.charAt(j) - 'A']++;

                maxCharCount = Math.max(charCounts[string.charAt(j) - 'A'], maxCharCount);

                int stringLength = j - i + 1;
                int replacementsNeeded = stringLength - maxCharCount;

                if (replacementsNeeded <= replacementsAllowed) {
                    longestSubStringLength = Math.max(stringLength, longestSubStringLength);
                }
            }
        }

        return longestSubStringLength;
    }

    static int characterReplacement2(String string, int replacementsAllowed) {
        int left = 0;
        int right = 0;
        int longestSubStringLength = 0;
        int maxCharCount = 0;
        int[] charCounts = new int[26];

        while (right < string.length()) {
            charCounts[string.charAt(right) - 'A']++;

            maxCharCount = Math.max(maxCharCount, charCounts[string.charAt(right) - 'A']);

            int windowLength = right - left + 1;
            int replacementsNeeded = windowLength - maxCharCount;

            while (replacementsNeeded > replacementsAllowed) {
                charCounts[string.charAt(left) - 'A']--;
                left++;

                windowLength = right - left + 1;
                replacementsNeeded = windowLength - maxCharCount;
            }

            longestSubStringLength = Math.max(longestSubStringLength, right - left + 1);

            right++;

        }

        return longestSubStringLength;
    }
}