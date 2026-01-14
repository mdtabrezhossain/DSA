import java.util.ArrayList;
import java.util.Arrays;

class SortedSquares {
    public static void main(String[] args) {
        int[] nums = { -7, -3, 2, 3, 11 };
        System.out.println(Arrays.toString(sortedSquares(nums)));

    }

    static int[] sortedSquares(int[] nums) {
        ArrayList<Integer> negativeNumsList = new ArrayList<>();
        ArrayList<Integer> positiveNumsList = new ArrayList<>();

        // separate negative and postiive numbers
        for (int num : nums) {
            if (num < 0) {
                negativeNumsList.add(num);
            } else {
                positiveNumsList.add(num);
            }
        }

        int[] negativeNums = new int[negativeNumsList.size()];
        int[] positiveNums = new int[positiveNumsList.size()];
        negativeNums = copyListToArray(negativeNumsList);
        positiveNums = copyListToArray(positiveNumsList);

        // if input array contains has only positive numbers, simply square them
        if (negativeNums.length == 0) {
            squareArray(nums);
        }

        // if it has only negative numbers, reverse the numbers and square them
        else if (positiveNums.length == 0) {
            reverseArray(nums);
            squareArray(nums);
        }

        // or else both negative and positive numbers
        else {
            // square the arrays
            squareArray(negativeNums);
            squareArray(positiveNums);

            /*
             * Keep a pointer at the end of array containing square of negative numbers. And
             * another pointer at the start of array containing square of positive numbers.
             * Compare the pointed numbers and place in the final array.
             */
            int i = negativeNums.length - 1;
            int j = 0;
            int k = 0;

            while (i >= 0 && j <= positiveNums.length - 1) {
                if (negativeNums[i] < positiveNums[j]) {
                    nums[k] = negativeNums[i];
                    k++;
                    i--;
                } else {
                    nums[k] = positiveNums[j];
                    k++;
                    j++;
                }
            }

            while (i >= 0) {
                nums[k] = negativeNums[i];
                k++;
                i--;
            }

            while (j <= positiveNums.length - 1) {
                nums[k] = positiveNums[j];
                k++;
                j++;
            }
        }

        return nums;
    }

    static int[] copyListToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];

        for (int i = 0; i <= list.size() - 1; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    static void squareArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] *= array[i];
        }
    }

    static void reverseArray(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;

        while (i <= j) {
            int leftSquare = nums[i] * nums[i];
            int rightSquare = nums[j] * nums[j];

            if (leftSquare > rightSquare) {
                result[k] = leftSquare;
                i++;
            } else {
                result[k] = rightSquare;
                j--;
            }

            k--;
        }

        return result;
    }
}
