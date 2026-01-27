import java.util.Arrays;

class MinMeetingRooms {
    static int getMinimumRequiredRooms(int[] startTimes, int[] endTimes) {
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int rooms = 0;
        int minRooms = 0;
        int i = 0;
        int j = 0;

        while (i <= startTimes.length - 1) {
            if (startTimes[i] < endTimes[j]) {
                rooms++;
                minRooms = Math.max(rooms, minRooms);

                i++;

            } else {
                rooms--;
                j++;
            }
        }

        return minRooms;

    }
}
