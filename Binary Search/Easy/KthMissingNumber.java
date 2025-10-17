package Easy;

class KthMissingNumber {
    public static void main(String[] args) {
        int[] array = { 3, 5, 7, 11 };
        int k = 4;

        // // Approach 1 ---
        // int max = Integer.MIN_VALUE;

        // for (int num : array) {
        // max = Math.max(num, max);
        // }

        // boolean[] isPresentInArrayHashTable = new boolean[max + 1];

        // for (int num : array) {
        // isPresentInArrayHashTable[num] = true;
        // }

        // for (int num = 1, missingCount = 0; num <= isPresentInArrayHashTable.length -
        // 1; num++) {
        // if (!isPresentInArrayHashTable[num]) {
        // missingCount++;

        // if (missingCount == k) {
        // System.out.println(num);
        // }
        // }
        // }

        // Approach 2 ---
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] <= k) {
                k++;
            } else {
                System.out.println(k);
                break;
            }
        }

    }
}
