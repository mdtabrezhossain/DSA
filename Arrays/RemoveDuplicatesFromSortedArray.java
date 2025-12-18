import java.util.ArrayList;
import java.util.HashSet;

class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // Approach 1 ---
        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(2);
        // numbers.add(3);
        // numbers.add(3);
        // numbers.add(3);
        // numbers.add(4);
        // numbers.add(4);
        // numbers.add(4);
        // numbers.add(4);
        // System.out.println(numbers);

        // ArrayList<Integer> seenNumbers = new ArrayList<>();
        // ArrayList<Integer> idxToRemove = new ArrayList<>();

        // int size = numbers.size();
        // for (int i = 0; i <= size - 1; i++) {
        // Integer currentNumber = numbers.get(i);

        // if (seenNumbers.contains(currentNumber)) {
        // idxToRemove.add(i);
        // }

        // else if (!seenNumbers.contains(currentNumber)) {
        // seenNumbers.add(currentNumber);
        // }
        // }

        // for (int i = idxToRemove.size() - 1; i >= 0; i--) {
        // numbers.remove((int) idxToRemove.get(i));
        // }

        // System.out.println(numbers);

        // Approach 2 ---
        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(2);
        // numbers.add(3);
        // numbers.add(3);
        // numbers.add(3);
        // numbers.add(4);
        // numbers.add(4);
        // numbers.add(4);
        // numbers.add(4);
        // System.out.println(numbers);

        // HashSet<Integer> uniqueNumbers = new HashSet<>();

        // for (Integer number : numbers) {
        // uniqueNumbers.add(number);
        // }

        // numbers.clear();
        // for (Integer uniqueNumber : uniqueNumbers) {
        // numbers.add(uniqueNumber);
        // }

        // System.out.println(numbers);

        // Approach 3 ----
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        System.out.println(numbers);

        int i = 0;
        for (int j = 1; j <= numbers.size() - 1; j++) {
            if (!numbers.get(i).equals(numbers.get(j))) {
                numbers.add(++i, numbers.get(j));
            }
        }

        while (numbers.size() - 1 > i) {
            numbers.remove(numbers.size() - 1);
        }

        System.out.println(numbers);
    }
}