public class SingleAmongTwins {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5 };

        // // Approach 1 ---
        // for (int i = 0; i <= arr.length - 1; i++) {
        // if (i == 0) {
        // if (arr[i] != arr[i + 1]) {
        // System.out.println(arr[i]);
        // }
        // } else if (i == arr.length - 1) {
        // if (arr[i] != arr[i - 1]) {
        // System.out.println(arr[i]);
        // }
        // } else {
        // if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
        // System.out.println(arr[i]);
        // }
        // }
        // }

        // Approach 2 ---
        int result = findSingleElement2(arr);
        System.out.println(result);
    }

    static int findSingleElement2(int[] arr) {

        // Only one element in the array
        if (arr.length == 1) {
            return arr[0];
        }

        // Single element is at the beginning
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // Single element is at the end
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int startIdx = 1;
        int endIdx = arr.length - 2;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (arr[midIdx] != arr[midIdx - 1] && arr[midIdx] != arr[midIdx + 1]) {
                return arr[midIdx];
            }

            // Now decide which half to search next based on index parity pattern:
            //
            // Before the single element:
            // Pairs start at even indices → (0,1), (2,3), (4,5), ...
            // After the single element:
            // Pairs start at odd indices → (1,2), (3,4), (5,6), ...
            //
            // So:
            // - If mid is odd and matches left → pattern still correct → go right
            // - If mid is even and matches right → pattern still correct → go right
            // - Otherwise, pattern broken → single element is to the left
            else if ((midIdx % 2 == 1 && arr[midIdx] == arr[midIdx - 1]) ||
                    (midIdx % 2 == 0 && arr[midIdx] == arr[midIdx + 1])) {
                // Move to the right half
                startIdx = midIdx + 1;
            }

            // Pattern broken → move to the left half
            else {
                endIdx = midIdx - 1;
            }
        }

        return Integer.MIN_VALUE;
    }

}
