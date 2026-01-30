class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = { 7, 8, 9, 1, 2, 4, 5, 6 };
        // Approach 1 : Linear Search

        // Approach 2:
        int low = 0;
        int high = array.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] <= array[array.length - 1]) {
                min = Math.min(min, array[mid]);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum element in the rotated sorted array: " + min);
    }
}