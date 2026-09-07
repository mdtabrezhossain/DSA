class Subsets2 {
    List<List<Integer>> uniqueSubsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(numbers);
        helper(0, subset, result, numbers);

        return result;
    }

    void helper(int i, List<Integer> subset, List<List<Integer>> result, int[] numbers) {
        if (i == numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        int number = numbers[i];

        subset.add(number);
        helper(i + 1, subset, result, numbers);

        subset.remove(subset.size() - 1);

        while (i < numbers.length - 1 && (numbers[i] == numbers[i + 1]))
            i++;

        helper(i + 1, subset, result, numbers);
    }
}