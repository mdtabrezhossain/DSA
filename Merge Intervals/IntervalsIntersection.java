import java.util.ArrayList;

class IntervalsIntersection {
    static int[][] findIntervalIntersection1(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> resultList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i <= firstList.length - 1 && j <= secondList.length - 1) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            int intersectionStart = Math.max(start1, start2);
            int intersectionEnd = Math.min(end1, end2);

            if (intersectionStart <= intersectionEnd) {
                resultList.add(new int[] { intersectionStart, intersectionEnd });
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    static int[][] findIntervalIntersection2(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> resultList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i <= firstList.length - 1 && j <= secondList.length - 1) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if (start1 <= start2) {
                if (start2 <= end1) {
                    int intersectionStart = start2;
                    int intersectionEnd = Math.min(end1, end2);

                    resultList.add(new int[] { intersectionStart, intersectionEnd });
                }
            } else {
                if (start1 <= end2) {
                    int intersectionStart = start1;
                    int intersectionEnd = Math.min(end1, end2);

                    resultList.add(new int[] { intersectionStart, intersectionEnd });
                }
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
