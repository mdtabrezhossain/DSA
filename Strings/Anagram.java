class Anagram {
    public static void main(String[] args) {
        String word1 = "anagram";
        String word2 = "gamaran";

        if (word1.length() != word2.length()) {
            System.out.println("Are anagram?: false");
            return;
        }

        // // Approach 1 ---
        // char[] letters1 = word1.toCharArray();
        // Arrays.sort(letters1);
        // String s1 = new String(letters1);
        // System.out.println(s1);

        // char[] letters2 = word2.toCharArray();
        // Arrays.sort(letters2);
        // String s2 = new String(letters2);
        // System.out.println(s2);

        // System.out.println("Anagram strings?: " + s1.equals(s2));

        // Approach 2 ---
        int[] alphabetCount = new int[26];

        for (int i = 0; i <= word1.length() - 1; i++) {
            int index = word1.charAt(i) - 'a';
            alphabetCount[index]++;
        }

        for (int i = 0; i <= word2.length() - 1; i++) {
            int index = word2.charAt(i) - 'a';
            alphabetCount[index]--;

            if (alphabetCount[index] < 0) {
                System.out.println("Are anagram?: false");
                return;
            }
        }

        System.out.println("Are anagram?: true");
    }
}
