import java.util.HashMap;

class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        int result = longestSubArrayWithAtMostKDistinctElements(fruits);
        System.out.println(result); // Output: 5

    }

    static int longestSubArrayWithAtMostKDistinctElements(int[] fruits) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> fruitTypeCountMap = new HashMap<>();

        while (right <= fruits.length - 1) {
            fruitTypeCountMap.put(fruits[right],
                    fruitTypeCountMap.getOrDefault(fruits[right], 0) + 1);

            while (fruitTypeCountMap.size() > 2) {
                int newCount = fruitTypeCountMap.get(fruits[left]) - 1;

                if (newCount == 0) {
                    fruitTypeCountMap.remove(fruits[left]);
                } else {
                    fruitTypeCountMap.put(fruits[left], newCount);
                }

                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);

            right++;
        }

        return maxLength;
    }
}
