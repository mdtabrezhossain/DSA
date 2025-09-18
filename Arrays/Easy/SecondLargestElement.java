class SecondLargestElement {
    public static void main(String[] args) {

        int[] array = { 7, 2, 5, 3, 8, 0, 10, 10 };

        // Approach 1 ---
        // for (int i = 0; i <= array.length - 1; i++) {
        // boolean swapped = false;

        // for (int j = 0; j <= (array.length - 2 - i); j++) {
        // if (array[j] > array[j + 1]) {
        // int temp = array[j];
        // array[j] = array[j + 1];
        // array[j + 1] = temp;

        // swapped = true;
        // }
        // }

        // if (!swapped) {
        // break;
        // }
        // }

        // int secondLargest = Integer.MIN_VALUE;

        // for (int i = (array.length - 2); i > -1; i--) {
        // if (array[i] != array[array.length - 1]) {
        // secondLargest = array[i];
        // break;
        // }
        // }

        // System.out.printf("Second largest element: %d", secondLargest);

        // Approach 2 ---
        // int largest = array[0];
        // int secondLargest = Integer.MIN_VALUE;

        // for (int num : array) {
        // if (num > largest) {
        // largest = num;
        // }
        // }

        // for (int num : array) {
        // if (num != largest && num < largest && num > secondLargest) {
        // secondLargest = num;
        // }
        // }

        // System.out.printf("Second largest element: %d", secondLargest);

        // Approach 3 ---
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }

            else if (num != largest && num > secondLargest) {
                secondLargest = num;
            }

        }

        System.out.printf("Largest element: %d", largest);
        System.out.printf("\nSecond largest element: %d", secondLargest);
    }
}
