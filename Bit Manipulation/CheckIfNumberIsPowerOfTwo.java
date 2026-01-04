class CheckIfNumberIsPowerOfTwo {
    public static void main(String[] args) {
        int number = 15;

        // // Approach 1 ---
        // String binaryString = Integer.toBinaryString(number);
        // int setBitCount = 0;
        // boolean isNumberPowerOfTwo = true;

        // for (char bit : binaryString.toCharArray()) {
        // if (setBitCount > 1) {
        // isNumberPowerOfTwo = false;
        // break;
        // } else if (bit == '1') {
        // setBitCount++;
        // }
        // }

        // if (isNumberPowerOfTwo) {
        // System.out.println("The number is power of 2");
        // } else {
        // System.out.println("The number is power of 2");
        // System.out.println("The number is NOT power of 2");
        // }

        // Approach 2 ---
        if ((number & number - 1) == 0) {
            System.out.println("The number is power of 2");
        } else {
            System.out.println("The number is NOT power of 2");
        }

    }
}
