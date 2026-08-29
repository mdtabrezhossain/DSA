class LastStoneWeight {
    int lastStoneWeight(int[] stones) {
        while (stones.length > 1) {
            Arrays.sort(stones);

            int n = stones.length;
            int x = stones[n - 1];
            int y = stones[n - 2];

            if (x == y) {
                stones = Arrays.copyOf(stones, n - 2);
            } else {
                stones[n - 2] = x - y;
                stones = Arrays.copyOf(stones, n - 1);
            }
        }

        return stones.length == 0 ? 0 : stones[0];
    }

    int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int weight : stones)
            maxHeap.offer(weight);

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x == y)
                continue;

            maxHeap.offer(x - y);
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}