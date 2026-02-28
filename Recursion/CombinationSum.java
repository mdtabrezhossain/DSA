import java.util.ArrayList;

class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        helper(candidates, target, resultList, combination, 0, 0);
        return resultList;
    }

    static void helper(
            int[] array,
            int target,
            ArrayList<ArrayList<Integer>> subSetsList,
            ArrayList<Integer> subSet,
            int sum,
            int idx) {
        if (idx == array.length || sum > target) {
            return;
        }

        if (sum == target) {
            subSetsList.add(new ArrayList<>(subSet));
            return;
        }

        int number = array[idx];

        subSet.add(number);
        sum += number;
        helper(array, target, subSetsList, subSet, sum, idx);
        subSet.remove(subSet.size() - 1);
        sum -= number;

        helper(array, target, subSetsList, subSet, sum, idx + 1);
    }
}