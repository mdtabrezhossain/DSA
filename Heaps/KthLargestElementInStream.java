class KthLargestElementInStream {
    PriorityQueue<Integer> minHeap;
    int K;

    KthLargest(int k, int[] stream) {
        K = k;
        minHeap = new PriorityQueue<>();

        for (int value : stream) {
            minHeap.offer(value);

            if (minHeap.size() > K)
                minHeap.poll();
        }
    }

    int add(int value) {
        minHeap.offer(value);

        if (minHeap.size() > K)
            minHeap.poll();

        return minHeap.peek();
    }
}