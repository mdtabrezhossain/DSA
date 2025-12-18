class LowerBound {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 2, 3, 4, 5, 5, 10, 10, 11, 11 };
        int target = 9;
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        int lowerBound = numbers.length;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (numbers[midIdx] >= target) {
                lowerBound = midIdx;
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }

        System.out.printf("Smallest index at which the element is greater than equal to target: %d", lowerBound);
    }
}