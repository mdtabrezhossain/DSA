import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TaskScheduler {
    static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : tasks) {
            charCountMap.put(
                    c, charCountMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(charCountMap.entrySet());

        int interval = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            ArrayList<Map.Entry<Character, Integer>> temp = new ArrayList<>();

            while (cycle > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                interval++;
                cycle--;

                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    temp.add(entry);
                }
            }

            maxHeap.addAll(temp);

            if (!maxHeap.isEmpty()) {
                interval += cycle;
            }
        }

        return interval;
    }
}