import java.util.ArrayList;
import java.util.HashSet;

class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 2, 3, 4, 4, 4 };
        int[] arr2 = { 1, 2, 3, 3, 5, 5, 6, 6 };

        // Approach 1 ---
        // HashSet<Integer> union = new HashSet<>();

        // for (int num : arr1) {
        // union.add(num);
        // }

        // for (int num : arr2) {
        // union.add(num);
        // }

        // System.out.println(union);

        // Approach 2 ---

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i <= arr1.length - 1 && j <= arr2.length - 1) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || arr1[i] != union.get(union.size() - 1)) {
                    union.add(arr1[i]);
                }

                i++;
            } else {
                if (union.isEmpty() || arr2[j] != union.get(union.size() - 1)) {
                    union.add(arr2[j]);
                }

                j++;
            }
        }

        while (i <= arr1.length - 1) {
            if (union.isEmpty() || arr1[i] != union.get(union.size() - 1)) {
                union.add(arr1[i]);
            }

            i++;
        }

        while (j <= arr2.length - 1) {
            if (union.isEmpty() || arr2[j] != union.get(union.size() - 1)) {
                union.add(arr2[j]);
            }

            j++;
        }

        System.out.println(union);
    }
}
