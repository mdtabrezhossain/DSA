class MinimumWindowSubstring {
    String minWindow(String text, String target) {
        String result = "";
        int minLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : target.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i = 0; i < text.length(); i++) {
            HashMap<Character, Integer> temp = new HashMap<>(map);

            for (int j = i; j < text.length(); j++) {
                char c = text.charAt(j);

                if (temp.containsKey(c)) {
                    int newCount = temp.get(c) - 1;

                    if (newCount == 0)
                        temp.remove(c);
                    else
                        temp.put(c, newCount);

                    if (temp.isEmpty()) {
                        int currentLength = j - i + 1;

                        if (currentLength < minLength) {
                            result = text.substring(i, j + 1);
                            minLength = currentLength;
                        }

                        break;
                    }
                }
            }
        }

        return result;
    }

    String minWindow2(String text, String target) {
        int[] need = new int[128];

        for (char c : target.toCharArray())
            need[c]++;

        String result = "";
        int minLength = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int count = target.length();

        while (end < text.length()) {
            char c = text.charAt(end);

            if (need[c] > 0)
                count--;

            need[c]--;

            while (count == 0) {
                int length = end - start + 1;

                if (length < minLength) {
                    result = text.substring(start, end + 1);
                    minLength = length;
                }

                c = text.charAt(start);
                need[c]++;

                if (need[c] > 0)
                    count++;

                start++;
            }

            end++;
        }

        return result;
    }
}
