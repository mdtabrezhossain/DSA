class CombinationSum {
    List<List<Integer>> combinationSum(int[] numbers, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(0, target, subset, result, numbers);

        return result;
    }

    void helper(int i, int sum, List<Integer> subset, List<List<Integer>> result, int[] numbers) {
        if (sum == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (i == numbers.length)
            return;

        int number = numbers[i];

        if (number <= sum) {
            subset.add(number);
            helper(i, sum - number, subset, result, numbers);

            subset.remove(subset.size() - 1);
        }

        helper(i + 1, sum, subset, result, numbers);
    }
}