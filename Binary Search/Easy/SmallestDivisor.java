package Easy;

class SmallestDivisor {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 9 };
        int limit = 6;

        // // Approach 1 ---
        // int max = Integer.MIN_VALUE;
        // int smallestDivisor = 0;

        // for (int i = 0; i <= arr.length - 2;) {
        // if (arr[i] > max && arr[i] > arr[i + 1]) {
        // max = arr[i];
        // } else if (arr[i + 1] > max && arr[i + 1] > arr[i]) {
        // max = arr[i + 1];
        // }

        // i += 2;
        // }

        // for (int divisor = 1; divisor <= max; divisor++) {
        // int sum = 0;

        // for (int num : arr) {
        // sum += Math.ceil((double) num / (double) divisor);
        // }

        // if (sum <= limit) {
        // smallestDivisor = divisor;
        // break;
        // }
        // }

        // System.out.println(smallestDivisor);

        // Approach 2 ---
        int max = Integer.MIN_VALUE;
        int smallestDivisor = 0;

        for (int i = 0; i <= arr.length - 2;) {
            if (arr[i] > max && arr[i] > arr[i + 1]) {
                max = arr[i];
            } else if (arr[i + 1] > max && arr[i + 1] > arr[i]) {
                max = arr[i + 1];
            }

            i += 2;
        }

        int startNum = 1;
        int endNum = max;

        while (startNum <= endNum) {
            int sum = 0;
            int midNum = startNum + (endNum - startNum) / 2;

            for (int num : arr) {
                sum += Math.ceil((double) num / (double) midNum);
            }

            if (sum <= limit) {
                smallestDivisor = midNum;
                endNum = midNum - 1;
            } else {
                startNum = midNum + 1;
            }

        }

        System.out.println(smallestDivisor);

    }
}