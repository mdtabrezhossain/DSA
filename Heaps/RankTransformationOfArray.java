import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

class RankTransformationOfArray {
    public static void main(String[] args) {
        int[] array = { 40, 10, 20, 30 };
        // int[] array = { 40, 40, 40, 40 };

        HashMap<Integer, Integer> elementRankMap = new HashMap<>();

        // // Approach 1 ---
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // // push only unique elements into heap
        // for (int num : array) {
        // if (!elementRankMap.containsKey(num)) {
        // elementRankMap.put(num, 0);
        // minHeap.add(num);
        // }
        // }

        // // assign ranks
        // int rank = 1;
        // while (!minHeap.isEmpty()) {
        // int element = minHeap.poll();
        // elementRankMap.put(element, rank++);
        // }

        // // transform original array
        // for (int i = 0; i < array.length; i++) {
        // array[i] = elementRankMap.get(array[i]);
        // }

        // Approach 2 ---

        // remove duplicate and sort array
        TreeSet<Integer> orderedElementSet = new TreeSet<>();
        for (int num : array) {
            orderedElementSet.add(num);
        }

        // assign ranks
        int rank = 1;
        for (int num : orderedElementSet) {
            elementRankMap.put(num, rank);
            rank++;
        }

        // transform the array
        for (int i = 0; i < array.length; i++) {
            array[i] = elementRankMap.get(array[i]);
        }

        System.out.println(Arrays.toString(array));
    }
}