class KthLargestElementInArray {
    int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : numbers) {
            minHeap.offer(value);

            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}