import java.util.HashMap;

class LongestSubArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int k = 3;
        int longestSubArrayLength = 0;

        // Approach 1 ---
        // for (int i = 0; i <= arr.length - 1; i++) {
        // int sum = 0;

        // for (int j = i; j <= arr.length - 1; j++) {
        // sum += arr[j];

        // if (sum == k && (j - i + 1) > longestSubArrayLength) {
        // longestSubArrayLength = j - i + 1;
        // }
        // }
        // }

        // System.out.println(longestSubArrayLength);

        // Approach 2 ---
        HashMap<Integer, Integer> prefixSumIndexMap = new HashMap<>();

        int sum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            sum += arr[i];
            prefixSumIndexMap.put(sum, i);

            if (sum == k && (i + 1) > longestSubArrayLength) {
                longestSubArrayLength = i + 1;
            }

            else if (prefixSumIndexMap.containsKey(sum - k)
                    && (i - prefixSumIndexMap.get(sum - k) > longestSubArrayLength)) {
                longestSubArrayLength = i - prefixSumIndexMap.get(sum - k);
            }
        }

        System.out.println(longestSubArrayLength);
    }
}