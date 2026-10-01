class SearchInRotatedSortedArray {
    int search0(int[] numbers, int target) {
        int i = findPivot(numbers);

        int result = binarySearch(numbers, target, 0, i - 1);

        if (result != -1)
            return result;

        return binarySearch(numbers, target, i, numbers.length - 1);
    }

    private int findPivot(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (numbers[mid] > numbers[end])
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    private int binarySearch(int[] numbers, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (numbers[mid] == target)
                return mid;
            else if (numbers[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    int search2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == numbers[mid])
                return mid;

            if (numbers[mid] > numbers[end]) {
                if (numbers[start] <= target && target <= numbers[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (numbers[mid] <= target && target <= numbers[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
