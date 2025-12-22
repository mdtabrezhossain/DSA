class LargestOddNumber {
    public static void main(String[] args) {
        String str = "6783842";
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = str.charAt(i) - '0';
            if ((digit > 0 && digit <= 9) && digit % 2 != 0) {
                result = str.substring(0, i + 1);
                break;
            }
        }

        System.out.println("Largest odd number: " + result);

    }
}