class MergeIntervals {
    int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        list.addAll(Arrays.asList(intervals));

        boolean foundOverlap = true;

        while (foundOverlap) {
            foundOverlap = false;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    if (a[0] <= b[1] && b[0] <= a[1]) {
                        int start = Math.min(a[0], b[0]);
                        int end = Math.max(a[1], b[1]);

                        list.remove(j);
                        list.remove(i);

                        list.add(new int[] { start, end });

                        foundOverlap = true;
                        break;
                    }
                }

                if (foundOverlap)
                    break;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (prevEnd >= start) {
                int newEnd = Math.max(end, prevEnd);
                prevEnd = newEnd;
            } else {
                result.add(new int[] { prevStart, prevEnd });

                prevStart = start;
                prevEnd = end;
            }
        }

        result.add(new int[] { prevStart, prevEnd });

        return result.toArray(new int[result.size()][]);
    }

    int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int prevIdx = 0;

        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = intervals[prevIdx][1];

            int start = intervals[i][0];
            int end = intervals[i][1];

            if (prevEnd >= start) {
                int newEnd = Math.max(prevEnd, end);
                intervals[prevIdx][1] = newEnd;
            } else {
                prevIdx++;
                intervals[prevIdx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, prevIdx + 1);
    }
}