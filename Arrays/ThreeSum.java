import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum {
    public static void main(String[] args) {
        int[] array = { -1, 0, 1, 2, -1, -4 };
        ArrayList<ArrayList<Integer>> result = threeSum(array);
        System.out.println(result);
    }

    static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        /*
         * select the first element 'a' one by one.
         *
         * We run 'i' only till length - 3 index because a valid triplet requires three
         * elements (a, b, c).
         *
         * After fixing 'a', there must be at least two elements remaining
         * in the array to choose 'b' and 'c'.
         *
         * If 'i' goes beyond length - 3 index, there will not be enough
         * elements left to form a valid triplet.
         */
        for (int i = 0; i <= nums.length - 3; i++) {
            /*
             * skip current element'a' if its duplicate. If it happens the whole triplets
             * will repeat
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // make -a as target

            int target = -1 * nums[i];

            // start looking in the array after the current element 'a'
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);
                    triplets.add(nums[i]);

                    result.add(triplets);

                    left++;
                    right--;

                    /*
                     * skip the element which are equal to left element 'b' to avoid repeating the
                     * same triplet
                     */
                    while (left < nums.length - 1 && nums[left] == nums[left - 1])
                        left++;

                    /*
                     * skip the element which are equal to right element 'c' to avoid repeating the
                     * same triplet
                     */
                    while (right >= 0 && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }

        return result;
    }
}

/*
 * Idea: if a + b + c = 0, then b + c = -a. So we solve three sum with the help
 * of two-sum concept
 */
