import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class ThreeSum {
    static List<List<Integer>> threeSum(int[] array) {
        Arrays.sort(array);

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                for (int k = j + 1; k <= array.length - 1; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        List<Integer> triplets = Arrays.asList(array[i], array[j], array[k]);

                        set.add(triplets);
                    }
                }

            }
        }

        return new ArrayList<>(set);
    }

    static List<List<Integer>> threeSum2(int[] array) {
        Arrays.sort(array);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= array.length - 1; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;

            }

            int left = i + 1;
            int right = array.length - 1;
            int target = -array[i];

            while (left < right) {
                int sum = array[left] + array[right];

                if (sum == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));

                    left++;
                    right--;

                    while (left < array.length - 1 && array[left] == array[left - 1]) {
                        left++;
                    }

                    while (right > -1 && array[left] == array[left - 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return result;
    }
}
