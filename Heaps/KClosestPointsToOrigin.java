class KClosestPointsToOrigin {
    int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> Integer.compare(distance(a), distance(b)));
        return Arrays.copyOf(points, k);
    }

    int distance(int[] point) {
        int x = point[0];
        int y = point[1];

        // x2 = 0
        // y2 = 0

        return (x * x) + (y * y);
    }

    int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }

        return result;
    }
}