class DecodeWays {
    String message;
    int[] results;

    int numDecodings(String message) {
        this.message = message;

        this.results = new int[message.length()];
        Arrays.fill(results, -1);

        return countWays(0);
    }

    int countWays(int i) {
        if (i == message.length())
            return 1;

        char c = message.charAt(i);

        if (c == '0')
            return 0;

        if (results[i] != -1)
            return results[i];

        int ways = countWays(i + 1);

        if (i == message.length() - 1) {
            results[i] = ways;
            return ways;
        }

        int c2 = message.charAt(i + 1);

        if (c == '1' || (c == '2' && c2 <= '6')) {
            ways += countWays(i + 2);
            results[i] = ways;
        }

        return ways;
    }

    int numDecodings2(String message) {
        int[] results = new int[message.length() + 1];

        results[0] = 1;
        results[1] = message.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= message.length(); i++) {
            char current = message.charAt(i - 1);

            if (current != '0')
                results[i] += results[i - 1];

            char previous = message.charAt(i - 2);

            if (previous == '1' || (previous == '2' && current <= '6'))
                results[i] += results[i - 2];
        }

        return results[message.length()];
    }
}