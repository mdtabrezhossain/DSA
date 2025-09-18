class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 7, 8, 9 };
        int[] arr2 = { 7, 2, 5, 3, 8, 0, 10 };

        System.out.println(isArraySorted(arr1));
        System.out.println(isArraySorted(arr2));

    }

    static boolean isArraySorted(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
