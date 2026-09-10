import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (current == null)
                continue;

            int currentStart = current[0];
            int currentEnd = current[1];

            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];

                if (next == null)
                    continue;

                int nextStart = next[0];
                int nextEnd = next[1];

                if (currentEnd >= nextStart) {
                    int start = Math.min(currentStart, nextStart);
                    int end = Math.max(currentEnd, nextEnd);

                    current[0] = start;
                    current[1] = end;

                    // discard next interval after merge
                    intervals[j] = null;
                }
            }

            result.add(current);
        }

        return result.toArray(new int[result.size()][]);
    }

    int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                result.add(new int[] { currentStart, currentEnd });

                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        result.add(new int[] { currentStart, currentEnd });

        return result.toArray(new int[result.size()][]);
    }

    int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int currentIdx = 0;

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = intervals[currentIdx][1];

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                int newEnd = Math.max(currentEnd, nextEnd);
                intervals[currentIdx][1] = newEnd;
            } else {
                currentIdx++;
                intervals[currentIdx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, currentIdx + 1);
    }
}