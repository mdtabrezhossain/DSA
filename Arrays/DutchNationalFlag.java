import java.util.Arrays;

class DutchNationalFlag {
    public static void main(String[] args) {
        int[] array = { 2, 0, 2, 1, 1, 0 };
        sort2(array);
        System.out.println(Arrays.toString(array));
    }

    static void sort1(int[] array) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int num : array) {
            if (num == 0) {
                zeroCount++;
            }

            else if (num == 1) {
                oneCount++;
            }
        }

        for (int i = 0; i <= zeroCount - 1; i++) {
            array[i] = 0;
        }

        for (int i = zeroCount; i <= zeroCount + oneCount - 1; i++) {
            array[i] = 1;
        }

        for (int i = zeroCount + oneCount; i <= array.length - 1; i++) {
            array[i] = 2;
        }
    }

    static void sort2(int[] array) {
        int startPointer = 0;
        int midPointer = 0;
        int endPointer = array.length - 1;

        while (midPointer <= endPointer) {
            if (array[midPointer] == 0) {
                swapValues(array, midPointer, startPointer);
                startPointer++;
                midPointer++;
            } else if (array[midPointer] == 1) {
                midPointer++;
            } else {
                swapValues(array, midPointer, endPointer);
                endPointer--;
            }
        }
    }

    static void swapValues(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
