class TwoSum2 {
    static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (i < j) {
                    if (numbers[i] + numbers[j] == target) {
                        return new int[] { i + 1, j + 1 };
                    }
                } else {
                    break;
                }
            }
        }

        return new int[] { 0, 0 };
    }

    static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                left++;
                right--;
            }

        }

        return new int[] { 0, 0 };
    }
}
