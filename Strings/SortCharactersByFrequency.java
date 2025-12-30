import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SortCharactersByFrequency {
    public static void main(String[] args) {
        String word = "dabcdbda";
        StringBuilder result = new StringBuilder();

        // // Approach 1 ---
        // /*
        // * indices 0–25 → 'A' to 'Z'
        // * indices 26–51 → 'a' to 'z'
        // */
        // int[] letterCount = new int[52];

        // for (char c : word.toCharArray()) {
        // int index = -1;

        // if (c >= 65 && c <= 90) {
        // index = c - 65;
        // letterCount[index]++;
        // }

        // else if (c >= 97 && c <= 122) {
        // index = c - 97 + 26;
        // letterCount[index]++;
        // }
        // }

        // while (result.length() < word.length()) {

        // int maxCount = 0;
        // int maxIndex = -1;

        // // find character with max frequency
        // for (int i = 0; i <= letterCount.length - 1; i++) {
        // if (letterCount[i] > maxCount) {
        // maxCount = letterCount[i];
        // maxIndex = i;
        // }
        // }

        // // append it
        // char c;
        // if (maxIndex <= 25) {
        // c = (char) (maxIndex + 65);
        // } else {
        // c = (char) (maxIndex - 26 + 97);
        // }

        // for (int i = 1; i <= maxCount; i++) {
        // result.append(c);
        // }

        // // remove it
        // letterCount[maxIndex] = 0;
        // }
        // /*
        // * Note: Using <= causes one extra iteration after all characters are
        // consumed,
        // * leading to maxIndex = -1 and an array out-of-bounds exception.
        // */

        // Approach 2 ---
        HashMap<Character, Integer> letterCount = new HashMap<>();

        for (char letter : word.toCharArray()) {
            int count = letterCount.getOrDefault(letter, 0) + 1;
            letterCount.put(letter, count);
        }

        PriorityQueue<Map.Entry<Character, Integer>> frequencyQueue = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        frequencyQueue.addAll(letterCount.entrySet());

        while (!frequencyQueue.isEmpty()) {
            Map.Entry<Character, Integer> letterCountEntry = frequencyQueue.poll();
            String letter = String.valueOf(letterCountEntry.getKey());
            int count = letterCountEntry.getValue();
            result.append(letter.repeat(count));
        }

        System.out.println(result);
    }
}