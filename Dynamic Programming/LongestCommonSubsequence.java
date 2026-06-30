import java.util.Arrays;

class LongestCommonSubsequence {
    private int[][] memo;

    int lcs(String s1, String s2) {
        memo = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(s1.length(), s2.length(), s1, s2);
    }

    private int helper(int len1, int len2, String s1, String s2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        if (memo[len1][len2] != -1) {
            return memo[len1][len2];
        }

        int c1 = s1.charAt(len1 - 1);
        int c2 = s2.charAt(len2 - 1);

        if (c1 == c2) {
            int take = 1 + helper(len1 - 1, len2 - 1, s1, s2);
            return memo[len1][len2] = take;
        }

        int skipS1 = helper(len1 - 1, len2, s1, s2);
        int skipS2 = helper(len1, len2 - 1, s1, s2);

        return memo[len1][len2] = Math.max(skipS1, skipS2);
    }

    int lcs2(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        for (int len1 = 1; len1 < memo.length; len1++) {
            for (int len2 = 1; len2 < memo[0].length; len2++) {
                int c1 = s1.charAt(len1 - 1);
                int c2 = s2.charAt(len2 - 1);

                if (c1 == c2) {
                    int take = 1 + memo[len1 - 1][len2 - 1];
                    memo[len1][len2] = take;
                } else {
                    int skipS1 = memo[len1 - 1][len2];
                    int skipS2 = memo[len1][len2 - 1];
                    memo[len1][len2] = Math.max(skipS1, skipS2);
                }
            }
        }

        return memo[s1.length()][s2.length()];
    }
}