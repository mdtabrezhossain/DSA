import java.util.Collections;
import java.util.PriorityQueue;

class KthSmallestElement {
    static int findKthSmallest(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i <= k - 1; i++) {
            maxHeap.add(array[i]);
        }

        for (int i = k; i <= array.length - 1; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(array[i]);
            }
        }

        return maxHeap.peek();
    }
}
