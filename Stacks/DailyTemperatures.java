class DailyTemperatures {
    int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    int[] dailyTemperatures2(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentDay = temperatures.length - 1; currentDay > -1; currentDay--) {
            int currentTemperature = temperatures[currentDay];

            while (!stack.isEmpty() && temperatures[stack.peek()] <= currentTemperature) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int nextWarmerDay = stack.peek();
                results[currentDay] = nextWarmerDay - currentDay;
            }

            stack.push(currentDay);
        }

        return results;
    }
}