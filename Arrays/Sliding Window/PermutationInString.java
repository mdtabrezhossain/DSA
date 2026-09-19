class PermutationInString {
    boolean checkInclusion(String s1, String s2) {
        char[] givenChars = s1.toCharArray();
        Arrays.sort(givenChars);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String target = s2.substring(i, i + s1.length());

            char[] targetChars = target.toCharArray();
            Arrays.sort(targetChars);

            if (Arrays.equals(targetChars, givenChars)) {
                return true;
            }
        }

        return false;
    }

    boolean checkInclusion2(String s1, String s2) {
        int[] subStrCharFreqs = new int[26];

        for (char ch : s1.toCharArray()) {
            subStrCharFreqs[ch - 'a']++;
        }

        int[] windowCharFreqs = new int[26];
        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            windowCharFreqs[rightChar - 'a']++;

            int windowLength = right - left + 1;

            if (windowLength > s1.length()) {
                char leftChar = s2.charAt(left);
                windowCharFreqs[leftChar - 'a']--;
                left++;
            }

            windowLength = right - left + 1;

            if (windowLength == s1.length()) {
                if (Arrays.equals(windowCharFreqs, subStrCharFreqs)) {
                    return true;
                }
            }

            right++;
        }

        return false;
    }
}
