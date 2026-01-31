class SearchInRotatedSortedArray {
    static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid;
            }

            else if (array[mid] >= array[array.length - 1]) {
                if (array[mid] > target) {
                    if (target >= array[0]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    low = mid + 1;
                }
            }

            else {
                if (array[mid] > target) {
                    high = mid - 1;
                } else {
                    if (target <= array[array.length - 1]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
