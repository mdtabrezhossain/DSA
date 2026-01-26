class InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        int newIntervalStart = newInterval[0];
        boolean isNewIntervalInserted = false;

        int[][] tempIntervals = new int[intervals.length + 1][];
        int i;

        for (i = 0; i <= intervals.length - 1; i++) {
            int currentIntervalStart = intervals[i][0];

            if (!isNewIntervalInserted
                    && currentIntervalStart >= newIntervalStart) {
                tempIntervals[i] = newInterval;
                isNewIntervalInserted = true;
                break;
            } else {
                tempIntervals[i] = intervals[i];
            }
        }

        if (isNewIntervalInserted) {
            for (int j = i; j <= intervals.length - 1; j++) {
                tempIntervals[j + 1] = intervals[j];
            }
        } else {
            tempIntervals[i] = newInterval;
        }

        return MergeIntervals.merge(tempIntervals);
    }

}
