class LargestElement {
    public static void main(String[] args) {
        int[] array = { 7, 2, 5, 3, 8, 0, 10 };

        // Approach 1 ---
        // for (int i = 0; i <= (array.length - 1); i++) {
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

        // int largest = array[array.length - 1];

        // System.out.printf("Largest element: %d", largest);

        // Approach 2 ---
        int largest = array[0];

        for (int num : array) {
            if (num > largest) {
                largest = num;
            }
        }

        System.out.printf("Largest element: %d", largest);
    }
}