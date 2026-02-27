import java.util.Arrays;

class ProductExceptSelf {
    static int[] productExceptSelf(int[] array) {
        int product = 1;
        int zeroCount = 0;

        for (int n : array) {
            if (n != 0) {
                product *= n;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[array.length];
        }

        int[] result = new int[array.length];

        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != 0) {
                result[i] = zeroCount > 0
                        ? 0
                        : product / array[i];
            } else {
                result[i] = product;
            }
        }

        return result;
    }

    static int[] productExceptSelf2(int[] array) {
        int[] leftProducts = new int[array.length];
        leftProducts[0] = 1;
        int product = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            leftProducts[i] = product;
            product *= array[i];
        }

        int[] rightProducts = new int[array.length];
        rightProducts[rightProducts.length - 1] = 1;

        product = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            rightProducts[i] = product;
            product *= array[i];
        }

        int[] result = new int[array.length];

        for (int i = 0; i <= array.length - 1; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    static int[] productExceptSelf3(int[] array) {
        int[] result = new int[array.length];
        result[0] = 1;
        int product = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            result[i] = product;
            product *= array[i];
        }
        System.out.println(Arrays.toString(result));

        int[] rightProducts = new int[array.length];
        rightProducts[rightProducts.length - 1] = 1;

        product = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            rightProducts[i] = product;
            product *= array[i];
        }
        System.out.println(Arrays.toString(rightProducts));

        for (int i = 0; i <= array.length - 1; i++) {
            result[i] = result[i] * rightProducts[i];
        }

        return result;
    }
}
