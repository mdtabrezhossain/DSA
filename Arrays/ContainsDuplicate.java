import java.util.HashSet;

class ContainsDuplicate {
    static boolean hasDuplicate(int[] array) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
