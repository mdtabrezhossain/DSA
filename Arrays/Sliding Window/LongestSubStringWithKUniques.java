import java.util.HashMap;
import java.util.HashSet;

class LongestSubStringWithKUniques {

    public static void main(String[] args) {
        String string = "aabacbebebe";
        int k = 3;
        System.out.println(
                "Length longest substring containing 'K' different characters: " + longestKSubString2(string, k));
    }

    static int longestKSubString1(String s, int k) {
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));

                if (set.size() > k) {
                    break;
                }

                if (set.size() == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    static int longestKSubString2(String s, int k) {
        int maxLength = -1;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        while (end <= s.length() - 1) {

            // Expand the window and add a character
            charCountMap.put(
                    s.charAt(end),
                    charCountMap.getOrDefault(s.charAt(end), 0) + 1);

            /*
             * Shrink the window,
             * If there are more than 'K' different characters,
             * keep removing characters from the left side of the window
             */
            while (charCountMap.size() > k) {

                // Decrease the frequency of the character at start of the window
                int newCount = charCountMap.get(s.charAt(start)) - 1;

                if (newCount > 0) {
                    charCountMap.put(s.charAt(start), newCount);
                }

                // If the frequency is zero , remove the character from the map
                else {
                    charCountMap.remove(s.charAt(start));
                }

                start++;
            }

            if (charCountMap.size() == k) {
                maxLength = Math.max(end - start + 1, maxLength);
            }

            end++;
        }

        return maxLength;
    }

    /*
     * Note: Why it’s NOT O(n²)
     * 
     * The inner while loop does not restart for every end.
     * It only runs when needed and continues from where it last stopped.
     * So Even though there is a loop inside a loop, both pointers move only
     * forward, so the total time complexity is O(n), not O(n²).
     */
}
