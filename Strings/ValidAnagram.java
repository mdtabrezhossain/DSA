class ValidAnagram {
    static boolean isAnagram(String s, String t) {

        if (s.length() < t.length()
                || t.length() < s.length()) {
            return false;
        }

        int[] characters = new int[256];

        for (int c : s.toCharArray()) {
            characters[c]++;
        }

        for (int c : t.toCharArray()) {
            characters[c]--;

            if (characters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
