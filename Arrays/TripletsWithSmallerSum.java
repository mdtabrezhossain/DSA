import java.util.Arrays;

class TripletsWithSmallerSum {
    long countTriplets(int target, int array[]) {
        Arrays.sort(array);
        long tripletCount = 0;

        for (int i = 0; i <= array.length - 3; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                long sum = array[i] + array[left] + array[right];

                if (sum < target) {
                    tripletCount += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }

        return tripletCount;
    }
}
