class FibonacciNumber {
    int[] results;

    int fib(int n) {
        if (results == null) {
            results = new int[n + 1];
        }

        if (n == 0 || n == 1) {
            results[n] = n;
            return n;
        }

        if (results[n] != 0) {
            return results[n];
        }

        int a = fib(n - 1);
        int b = fib(n - 2);

        int value = a + b;
        results[n] = value;

        return value;
    }
}