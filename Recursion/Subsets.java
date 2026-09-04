class Subsets {
    List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(0, subset, result, numbers);

        return result;
    }

    void helper(int i, List<Integer> subset, List<List<Integer>> result, int[] numbers) {
        if (i == numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(numbers[i]);
        helper(i + 1, subset, result, numbers);

        subset.remove(subset.size() - 1);
        helper(i + 1, subset, result, numbers);
    }
}