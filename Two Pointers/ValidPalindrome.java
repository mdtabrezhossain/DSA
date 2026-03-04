class ValidPalindrome {
    static boolean isPalindrome(String inputString) {
        StringBuilder temp = new StringBuilder();

        for (Character c : inputString.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                temp.append(Character.toLowerCase(c));
            }
        }

        String string = temp.toString();
        String reverseString = temp.reverse().toString();
        return string.equals(reverseString);
    }

    static boolean isPalindrome2(String inputString) {
        int i = 0;
        int j = inputString.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(inputString.charAt(i))) {
                i++;
            }

            while (j > i && !Character.isLetterOrDigit(inputString.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(inputString.charAt(i)) != Character.toLowerCase(inputString.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
