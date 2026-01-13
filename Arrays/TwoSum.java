import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        int[] array = { 2, 7, 11, 15 };
        int target = 9;

        System.out.println(Arrays.toString(twoSum(array, target)));
        System.out.println(Arrays.toString(twoSum2(array, target)));
    }

    static int[] twoSum(int[] numbers, int target) {
        int[] result = { -1, -1 };

        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = 0; j <= numbers.length - 1; j++) {
                int sum = numbers[i] + numbers[j];

                if (sum == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }

        return result;
    }

    static int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] result = { -1, -1 };

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            }
        }

        return result;
    }
}