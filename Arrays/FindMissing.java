class FindMissing {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
        int n = 10;

        // Approach 1 ---
        // for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
        // boolean flag = false;

        // for (int number : numbers) {
        // if (number == currentNumber) {
        // flag = true;
        // }
        // }

        // if (flag == false) {
        // System.out.printf("%d ", currentNumber);
        // }
        // }

        // Approach 2 ---
        // int[] numberMap = new int[n + 1];

        // for (int number : numbers) {
        // numberMap[number] = 1;
        // }

        // for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
        // if (numberMap[currentNumber] == 0) {
        // System.out.printf("%d ", currentNumber);
        // }
        // }

        // Approach 3 ---
        // int expectedSum = (n * (n + 1)) / 2;
        // int actualSum = 0;

        // for (int number : numbers) {
        // actualSum += number;
        // }

        // System.out.println(expectedSum - actualSum);

        // Approach 4 ---
        int xorAll = 0;
        int xorArr = 0;

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            xorAll ^= currentNumber;
            System.out.println(xorAll);
        }

        for (int number : numbers) {
            xorArr ^= number;
        }

        System.out.printf("%d ", xorAll ^ xorArr);
    }
}
