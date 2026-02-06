import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ReorganizeString {
    static String reorganizeString(String s) {

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c,
                    charCountMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Character>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getKey() - a.getKey());

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            Integer count = entry.getValue();
            Character c = entry.getKey();

            maxHeap.offer(new AbstractMap.SimpleEntry<>(count, c));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Character> entry = maxHeap.poll();

            if (i == 0 || entry.getValue() != result.charAt(i - 1)) {
                result.append(entry.getValue());
                i++;

                if (entry.getKey() > 1) {
                    maxHeap.offer(
                            new AbstractMap.SimpleEntry<>(
                                    entry.getKey() - 1, entry.getValue()));
                }

            } else {

                if (maxHeap.isEmpty()) {
                    return "";
                }

                Map.Entry<Integer, Character> entry2 = maxHeap.poll();
                result.append(entry2.getValue());
                i++;

                if (entry2.getKey() > 1) {
                    maxHeap.offer(
                            new AbstractMap.SimpleEntry<>(
                                    entry2.getKey() - 1, entry2.getValue()));
                }

                maxHeap.offer(entry);

            }
        }

        return result.toString();
    }
}