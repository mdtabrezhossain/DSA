import java.util.Arrays;
import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int maxSequenceLength = 1;

        for (int i = 0; i <= array.length - 1; i++) {
            int target = array[i] + 1;
            int sequenceLength = 1;

            while (true) {
                boolean isTargetFound = false;

                for (int n : array) {
                    if (n == target) {
                        target++;
                        sequenceLength++;

                        maxSequenceLength = Math.max(maxSequenceLength, sequenceLength);

                        isTargetFound = true;
                        break;
                    }
                }

                if (!isTargetFound) {
                    break;
                }
            }
        }

        return maxSequenceLength;
    }

    static int longestConsecutive2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        Arrays.sort(array);
        int maxSequenceLength = 1;
        int sequenceLength = 1;

        for (int i = 0; i <= array.length - 2; i++) {
            if (array[i] + 1 == array[i + 1]) {
                sequenceLength++;
                maxSequenceLength = Math.max(maxSequenceLength, sequenceLength);
            } else if (array[i] == array[i + 1]) {
                continue;
            } else {
                sequenceLength = 1;
            }
        }

        return maxSequenceLength;
    }

    static int longestConsecutive3(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int n : array) {
            set.add(n);
        }

        int maxLength = 1;

        for (Integer n : set) {
            int previousNumber = n - 1;

            if (!set.contains(previousNumber)) {
                int length = 1;
                int nextElement = n + 1;

                while (set.contains(nextElement)) {
                    length++;
                    nextElement++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
