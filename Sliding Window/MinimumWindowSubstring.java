class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(getMinimumStringIncludingTarget(s, t));
        // Output : BANC
    }

    static String getMinimumStringIncludingTarget(String string, String target) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int[] neededCharCount = new int[128];

        for (char c : target.toCharArray()) {
            neededCharCount[c]++;
        }

        int[] haveCharCount = new int[128];
        while (right <= string.length() - 1) {
            char c = string.charAt(right);
            haveCharCount[c]++;

            while (isSufficient(haveCharCount, neededCharCount) && left <= right) {
                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStart = left;
                }

                haveCharCount[string.charAt(left)]--;
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : string.substring(minStart, minStart + minLength);
    }

    static boolean isSufficient(int[] haveCharCount, int[] neededCharCount) {
        for (int i = 0; i < haveCharCount.length; i++) {
            if (haveCharCount[i] < neededCharCount[i]) {
                return false;
            }
        }
        return true;
    }
}