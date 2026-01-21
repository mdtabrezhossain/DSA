class HappyNumber {
    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is Happy Number?: " + isHappy(num));
    }

    static boolean isHappy(int n) {
        int slowPtr = n;
        int fastPtr = n;

        do {
            slowPtr = getDigitSquareSum(slowPtr);
            fastPtr = getDigitSquareSum(fastPtr);
            fastPtr = getDigitSquareSum(fastPtr);
        } while (slowPtr != fastPtr);

        /*
         * If both pointers meet at 1, the number is happy.
         * Otherwise, they meet inside a cycle (unhappy number).
         */
        return slowPtr == 1;
    }

    static int getDigitSquareSum(int num) {
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
