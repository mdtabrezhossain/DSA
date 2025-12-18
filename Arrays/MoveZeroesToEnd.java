import java.util.Arrays;

class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] numbers = { 1, 0, 2, 0, 0, 3 };

        // Approach 1 ---
        // int[] nonZeroNumbers = new int[numbers.length];
        // int k = -1;

        // for (int i = 0; i <= numbers.length - 1; i++) {
        // if (numbers[i] != 0) {
        // nonZeroNumbers[++k] = numbers[i];
        // }
        // }

        // for (int i = 0; i <= numbers.length - 1; i++) {
        // numbers[i] = nonZeroNumbers[i];
        // }

        // System.out.println(Arrays.toString(numbers));

        // Approach 2 ---
        int i = -1;

        for (int j = 0; j <= numbers.length - 1; j++) {
            if (numbers[j] == 0) {
                i = j;
                break;
            }
        }

        if (i != -1) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[j] != 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}