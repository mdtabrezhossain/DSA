class _3Sum {
    List<List<Integer>> threeSum(int[] numbers) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    int first = numbers[i];
                    int second = numbers[j];
                    int third = numbers[k];

                    int sum = first + second + third;

                    if (sum == 0) {
                        List<Integer> triplet = Arrays.asList(first, second, third);

                        Collections.sort(triplet);
                        result.add(triplet);
                    }

                }
            }
        }

        return new ArrayList<>(result);
    }

    List<List<Integer>> threeSum2(int[] numbers) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int first = numbers[i];
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < numbers.length; j++) {
                int second = numbers[j];

                int third = -(first + second);

                if (set.contains(third)) {
                    List<Integer> triplet = Arrays.asList(first, second, third);

                    Collections.sort(triplet);
                    result.add(triplet);
                }

                set.add(second);
            }
        }

        return new ArrayList<>(result);
    }

    List<List<Integer>> threeSum3(int[] numbers) {
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;

            int first = numbers[i];

            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int second = numbers[left];
                int third = numbers[right];

                int sum = first + second + third;

                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(first, second, third);
                    result.add(triplet);

                    left++;
                    right--;

                    while (left < right && numbers[left] == numbers[left - 1])
                        left++;

                    while (right > left && numbers[right] == numbers[right + 1])
                        right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }

        return result;
    }
}