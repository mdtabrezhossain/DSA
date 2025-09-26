import java.util.ArrayList;

class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int[] arr2 = { 2, 3, 3, 5, 6, 6, 7 };
        ArrayList<Integer> intersection = new ArrayList<>();

        // Approach 1 ---
        // for (int i = 0; i <= arr1.length - 1; i++) {
        // for (int j = 0; j <= arr2.length - 1; j++) {
        // if (arr1[i] == arr2[j] &&
        // (intersection.isEmpty() || arr1[i] != intersection.get(intersection.size() -
        // 1))) {
        // intersection.add(arr1[i]);
        // break;
        // }
        // }
        // }

        // Approach 2 ---
        int i = 0;
        int j = 0;

        while (i <= arr1.length - 1 && j <= arr2.length - 1) {
            if (arr1[i] == arr2[j]) {
                if (intersection.isEmpty() || (arr1[i] != intersection.get(intersection.size() - 1))) {
                    intersection.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
        }

        System.out.println(intersection);
    }

}
