class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = { 7, 8, 9, 1, 2, 4, 5, 6 };
        // Approach 1 : Linear Search

        // Approach 2:
        int startIdx = 0;
        int endIdx = array.length - 1;
        int min = Integer.MAX_VALUE;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (array[startIdx] < array[endIdx]) {
                min = Math.min(array[startIdx], min);
                break;
            }

            /*
             * If the middle element is smaller than the element at the end, this means the
             * right part of the array is sorted and middle element is the smallest there.
             * So we store the value of the middle element. And start looking on the left
             * part of the array because there might be chances that the actual smallest
             * element lies there
             */
            if (array[midIdx] <= array[endIdx]) {
                endIdx = midIdx - 1;
                min = Math.min(array[midIdx], min);
            } else {
                min = Math.min(array[startIdx], min);
                startIdx = midIdx + 1;
            }
        }

        System.out.println("Minimum element in the rotated sorted array: " + min);

    }
}