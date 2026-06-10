class SearchInRotatedSortedArray {
    int search(int[] numbers, int target) {
        int minIdx = findMinIndex(numbers);
        int targetIdx = -1;

        targetIdx = binarySearch(numbers, target, 0, minIdx - 1);

        if (targetIdx != -1) {
            return targetIdx;
        }

        targetIdx = binarySearch(numbers, target, minIdx, numbers.length - 1);
        return targetIdx;
    }

    int search2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (numbers[mid] == target) {
                return mid;
            }

            if (numbers[start] <= numbers[mid]) {
                if (numbers[start] <= target && target <= numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else {
                if (numbers[mid] <= target && target <= numbers[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    private int findMinIndex(int[] numbers) {
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

        return start;
    }

    private int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
