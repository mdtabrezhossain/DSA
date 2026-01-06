class JumpGame {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 0, 4 };
        boolean canReachEnd = false;
        int maxJumpIndex = 0;

        for (int currentIndex = 0; currentIndex <= array.length - 1; currentIndex++) {
            if (currentIndex > maxJumpIndex) {
                break;
            }

            int indexesCanJump = array[currentIndex];
            maxJumpIndex = Math.max(currentIndex + indexesCanJump, maxJumpIndex);

            if (maxJumpIndex >= array.length - 1) {
                canReachEnd = true;
            }
        }

        System.out.println("Reached end of array: " + canReachEnd);
    }
}
