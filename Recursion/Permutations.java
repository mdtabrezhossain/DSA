class Permutations {
    List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] included = new boolean[numbers.length];

        helper(included, permutation, result, numbers);

        return result;
    }

    void helper(boolean[] included, List<Integer> permutation, List<List<Integer>> result, int[] numbers) {
        if (permutation.size() == numbers.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!included[i]) {
                permutation.add(numbers[i]);
                included[i] = true;

                helper(included, permutation, result, numbers);

                permutation.remove(permutation.size() - 1);
                included[i] = false;
            }
        }
    }
}
