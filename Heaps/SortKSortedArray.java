import java.util.Arrays;
import java.util.PriorityQueue;

class SortKSortedArray {
    public static void main(String[] args) {
        int[] array = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3; // represents the distance within which the answer for current index can be
                   // found. Going beyond this 'k' distance is useless.

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int currentIndex = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            minHeap.add(array[i]);

            if (minHeap.size() > k) {
                array[currentIndex] = minHeap.poll();
                currentIndex++;
            }
        }

        while (!minHeap.isEmpty()) {
            array[currentIndex] = minHeap.poll();
            currentIndex++;
        }

        System.out.println(Arrays.toString(array));
    }
}