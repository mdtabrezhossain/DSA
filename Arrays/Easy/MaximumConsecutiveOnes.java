class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1 };
        int maxCount = 0;
        int count = 0;

        for (int num : arr) {
            if (num == 1) {
                count += 1;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(maxCount);
    }
}
