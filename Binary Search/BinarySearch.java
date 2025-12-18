class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 7 };
        int targetElement = 5;
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        boolean flag = false;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (numbers[midIdx] == targetElement) {
                System.out.println(midIdx);
                flag = true;
                break;
            } else if (targetElement < numbers[midIdx]) {
                endIdx = midIdx - 1;
            } else if (targetElement > numbers[midIdx]) {
                startIdx = midIdx + 1;
            }
        }

        if (flag == false) {
            System.out.println("not found");
        }
    }
}