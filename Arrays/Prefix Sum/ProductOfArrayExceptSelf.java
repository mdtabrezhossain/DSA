class ProductOfArrayExceptSelf {
    int[] productExceptSelf(int[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = 1;

            for (int j = 0; j < numbers.length; j++)
                if (j != i)
                    result[i] *= numbers[j];

        }

        return result;
    }

    int[] productExceptSelf2(int[] numbers) {
        int[] left = new int[numbers.length];
        left[0] = 1;

        for (int i = 1; i < numbers.length; i++)
            left[i] = left[i - 1] * numbers[i - 1];

        int[] right = new int[numbers.length];
        right[right.length - 1] = 1;

        for (int i = numbers.length - 2; i >= 0; i--)
            right[i] = right[i + 1] * numbers[i + 1];

        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)
            result[i] = left[i] * right[i];

        return result;
    }
}