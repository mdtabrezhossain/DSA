class TwoSum {
    int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];

                if (sum == target)
                    return new int[] { i, j };

            }
        }

        return new int[] { -1, -1 };
    }

    int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int pair = target - numbers[i];

            if (map.containsKey(pair))
                return new int[] { i, map.get(pair) };

            map.put(numbers[i], i);
        }

        return new int[] { -1, -1 };
    }
}