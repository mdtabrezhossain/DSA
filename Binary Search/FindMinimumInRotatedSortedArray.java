class FindMinimumInRotatedSortedArray {
    int findMin(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return numbers[start];
    }
}
