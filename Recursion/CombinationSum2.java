class CombinationSum2 {
    List<List<Integer>> combinationSum2(int[] numbers, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(numbers);
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

            helper(i + 1, sum - number, subset, result, numbers);

            subset.remove(subset.size() - 1);
        }

        while (i < numbers.length - 1 && (numbers[i] == numbers[i + 1]))
            i++;

        helper(i + 1, sum, subset, result, numbers);
    }
}

/*
 * take the element
 * ↓
 * explore
 * 
 * don't take the element
 * ↓
 * skip equivalent duplicates
 * ↓
 * explore
 */

// Duplicate subsets are only skipped when we're choosing NOT to use the current
// particular value at that recursion level.