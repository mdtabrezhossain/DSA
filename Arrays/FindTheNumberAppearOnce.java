import java.util.TreeMap;

class FindTheNumberAppearOnce {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 5, 5, 4, 4, 1 };
        int result = 0;

        // Approach 1 ---
        // for (int i = 0; i <= numbers.length - 1; i++) {
        // int appearanceCount = 0;
        // int currentNumber = numbers[i];

        // for (int num : numbers) {
        // if (num == currentNumber) {
        // appearanceCount++;
        // }
        // }

        // if (appearanceCount == 1) {
        // result = currentNumber;
        // break;
        // }
        // }

        // System.out.println(result);

        // Approach 2 ---
        // int max = numbers[0];

        // for (int num : numbers) {
        // if (num > max) {
        // max = num;
        // }
        // }

        // int[] countHashTable = new int[max + 1];

        // for (int i = 0; i <= numbers.length - 1; i++) {
        // countHashTable[numbers[i]]++;
        // }

        // for (int i = 1; i <= countHashTable.length - 1; i++) {
        // if (countHashTable[i] == 1) {
        // result = i;
        // }
        // }

        // System.out.println(result);

        // Approach 3 ---
        for (int num : numbers) {
            result ^= num;
        }

        System.out.println(result);
    }
}
