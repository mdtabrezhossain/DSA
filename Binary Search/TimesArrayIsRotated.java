class TimesArrayIsRotated {
    public static void main(String[] args) {
        int[] array = { 7, 8, 9, 1, 2, 4, 5, 6 };

        int startIdx = 0;
        int endIdx = array.length - 1;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (array[startIdx] <= array[endIdx]) {
                if (array[startIdx] < min) {
                    min = array[startIdx];
                    minIdx = startIdx;
                }
                break;
            }

            if (array[midIdx] <= array[endIdx]) {
                endIdx = midIdx - 1;

                if (array[midIdx] < min) {
                    min = array[midIdx];
                    minIdx = midIdx;
                }
            } else {
                startIdx = midIdx + 1;

                if (array[startIdx] < min) {
                    min = array[startIdx];
                    minIdx = startIdx;
                }
            }
        }

        System.out.println("Number of times array is rotated: " + minIdx);
    }
}

/*
 * Here, the number of times the array is rotated will be equal to the index at
 * which the smallest element of the array is present. So we can use the concept
 * of Minimum Element In Rotated Sorted Array, to get our answer.
 */