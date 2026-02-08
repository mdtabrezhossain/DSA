import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class IPO {
    public int findMaximizedCapital(int maxDistinctProjects, int reserve, int[] profits, int[] capitals) {
        int[][] projects = new int[capitals.length][2];
        for (int i = 0; i <= capitals.length - 1; i++) {
            projects[i][0] = capitals[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        for (int noOfProjects = 1; noOfProjects <= maxDistinctProjects; noOfProjects++) {

            while (idx <= projects.length - 1
                    && projects[idx][0] <= reserve) {
                profitMaxHeap.offer(projects[idx][1]);
                idx++;
            }

            if (profitMaxHeap.isEmpty()) {
                break;
            }

            reserve += profitMaxHeap.poll();
        }

        return reserve;
    }
}
