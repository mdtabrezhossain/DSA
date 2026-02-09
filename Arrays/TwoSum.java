import java.util.Arrays;
import java.util.HashMap;

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
        int[] result = { -1, -1 };

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
                return result;
            }

            map.put(numbers[i], i);
        }

        return result;
    }
}