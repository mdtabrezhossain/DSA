package Easy;

class UpperBound {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 2, 3, 4, 5, 8, 8, 10, 11 };
        int target = 7;
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        int upperBound = numbers.length;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (numbers[midIdx] > target) {
                upperBound = midIdx;
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }

        System.out.printf("Smallest index at which the element is greater than the target is: %d", upperBound);

    }
}