import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    static int[] topKFrequent(int[] array, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (int num : array) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> freqToNumMinHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            freqToNumMinHeap.offer(entry);

            if (freqToNumMinHeap.size() > k) {
                freqToNumMinHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!freqToNumMinHeap.isEmpty()) {
            result[i++] = freqToNumMinHeap.poll().getKey();
        }

        return result;
    }
}
