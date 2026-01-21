class Solution {
    public static void main(String[] args) {
        int[] numbers = { 3, 1, 3, 4, 2 };
        System.out.println("Duplicate number: " + findDuplicate(numbers));
    }

    static int findDuplicate(int[] array) {
        int slowPtr = array[0];
        int fastPtr = array[0];

        // Detect cycle
        do {
            slowPtr = array[slowPtr];
            fastPtr = array[array[fastPtr]];
        } while (slowPtr != fastPtr);

        // Find entry point of cycle
        int tempPtr = array[0];
        while (tempPtr != slowPtr) {
            tempPtr = array[tempPtr];
            slowPtr = array[slowPtr];
        }

        return tempPtr;
    }
}
