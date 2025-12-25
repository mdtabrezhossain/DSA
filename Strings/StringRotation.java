class StringRotation {
    public static void main(String[] args) {
        String input = "abcde";
        String goal = "cdeab";

        if (input.length() != goal.length()) {
            System.out.println("String are not rotation of each other");
            return;
        }

        // Approach 1 ---
        // for (int i = 1; i <= input.length(); i++) {
        // String rotatedString = input.substring(i) + input.substring(0, i);
        // if (rotatedString.equals(goal)) {
        // System.out.println("Strings are rotation of each other");
        // return;
        // }
        // }

        // Approach 2 ---
        String temp = input + input;

        if (temp.contains(goal)) {
            System.out.println("String are rotation of each other");
            return;

        }

        System.out.println("String are not rotation of each other");
        return;
    }
}
