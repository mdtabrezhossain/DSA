class CountSetBits {
    public static void main(String[] args) {
        int number = 13;

        String binaryString = Integer.toBinaryString(number);
        System.out.println("Binary form of number: " + binaryString);
        int setBitCount = 0;

        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') {
                setBitCount++;
            }
        }

        System.out.println("Count of set bits: " + setBitCount);
    }
}
