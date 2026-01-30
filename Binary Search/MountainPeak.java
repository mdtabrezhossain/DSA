class MountainPeak {
    static int findPeakElement(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] > array[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}