class CheckOddEvenNumber {

    public static void main(String[] args) {
        int number = 7;

        // Approach 1 ---
        // String binaryString = Integer.toBinaryString(number);

        // if (binaryString.charAt(binaryString.length() - 1) == '1') {
        // System.out.println("The number is odd");
        // } else {
        // System.out.println("The number is even");
        // }

        // Approach 2 ---
        if ((number & 1) == 1) {
            System.out.println("The number is odd");
        } else {
            System.out.println("The number is even");
        }
    }
}
