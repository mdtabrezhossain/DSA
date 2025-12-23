class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = { "flower", "flows", "flow" };
        StringBuilder result = new StringBuilder();
        String baseWord = words[0];

        for (int i = 0; i <= baseWord.length() - 1; i++) {
            boolean isCommonPrefix = true;

            for (String word : words) {
                if (i == word.length()
                        ||
                        baseWord.charAt(i) != word.charAt(i)) {
                    isCommonPrefix = false;
                    break;
                }
            }

            if (isCommonPrefix) {
                result.append(baseWord.charAt(i));
            } else {
                break;
            }

        }

        System.out.println("The longest common prefix among all the words is: " + result);
    }
}