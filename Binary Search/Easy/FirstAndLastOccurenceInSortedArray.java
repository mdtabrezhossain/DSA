package Easy;

class FirstAndLastOccurrenceInSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 5, 6, 8, 8, 8, 9 };
        int target = 8;

        // // Approach 1 ---
        // int firstSeenIdx = -1;
        // int lastSeenIdx = -1;

        // for (int i = 0; i <= arr.length - 1; i++) {
        // if (arr[i] == target) {
        // if (firstSeenIdx == -1) {
        // firstSeenIdx = i;
        // }

        // lastSeenIdx = i;
        // }
        // }

        // System.out.printf("First Occurrence at index: %d \nLast Occurrence at index:
        // %d", firstSeenIdx, lastSeenIdx);

        // Approach 2 ---
        int firstSeenIdx = -1;
        int lastSeenIdx = -1;
        int start = 0;
        int end = arr.length - 1;
        int lowerBound = arr.length;
        int upperBound = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                lowerBound = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (lowerBound != arr.length && arr[lowerBound] == target) {
            firstSeenIdx = lowerBound;
            start = 0;
            end = arr.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    upperBound = mid;
                    start = mid + 1;
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (upperBound != arr.length) {
                lastSeenIdx = upperBound;
            }
        }

        System.out.printf("First occurrence at index: %d", firstSeenIdx);
        System.out.printf("\nLast occurrence at index: %d", lastSeenIdx);

    }
}
