import java.util.Arrays;
import java.util.ArrayList;

class MergeIntervals {
    static int[][] merge(int[][] intervals) {
        Arrays.sort(
                intervals,
                (a, b) -> Integer.compare(a[0], b[0]));

        int previousIntervalStart = intervals[0][0];
        int previousIntervalEnd = intervals[0][1];
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i <= intervals.length - 1; i++) {
            int currentIntervalStart = intervals[i][0];
            int currentIntervalEnd = intervals[i][1];

            if (previousIntervalEnd >= currentIntervalStart) {
                previousIntervalEnd = Math.max(previousIntervalEnd, currentIntervalEnd);
            } else {
                result.add(new int[] { previousIntervalStart, previousIntervalEnd });
                previousIntervalStart = currentIntervalStart;
                previousIntervalEnd = currentIntervalEnd;
            }
        }

        result.add(new int[] { previousIntervalStart, previousIntervalEnd });

        return result.toArray(new int[result.size()][]);
    }
}