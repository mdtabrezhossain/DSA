class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    void addNum(int num) {
        maxHeap.offer(num);

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
            minHeap.offer(maxHeap.poll());

        if (maxHeap.size() - minHeap.size() == 2)
            minHeap.offer(maxHeap.poll());

        if (minHeap.size() - maxHeap.size() == 2)
            maxHeap.offer(minHeap.poll());
    }

    double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;

    }
}