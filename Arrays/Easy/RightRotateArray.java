import java.util.Arrays;

class RightRotateArray {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int distance = 7;

        // Approach 1 ---
        // int[] temp = new int[numbers.length];

        // for (int i = 0; i < numbers.length; i++) {
        // int destinationIdx = (i + distance) % numbers.length;
        // temp[destinationIdx] = numbers[i];
        // }

        // for (int i = 0; i < numbers.length; i++) {
        // numbers[i] = temp[i];
        // }

        // Approach 2 ---
        // distance %= numbers.length;
        // int[] temp = new int[distance];

        // for (int i = 0; i < distance; i++) {
        // temp[i] = numbers[numbers.length - distance + i];
        // }

        // for (int i = numbers.length - 1; i >= distance; i--) {
        // numbers[i] = numbers[i - distance];
        // }

        // for (int i = 0; i < temp.length; i++) {
        // numbers[i] = temp[i];
        // }

        // Approach 3 ---
        distance %= numbers.length;
        reverseArray(numbers, 0, numbers.length - 1);
        reverseArray(numbers, 0, distance - 1);
        reverseArray(numbers, distance, numbers.length - 1);

        System.out.println(Arrays.toString(numbers));
    }

    static void reverseArray(int[] array, int startIdx, int endIdx) {
        for (int i = startIdx, j = endIdx; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}