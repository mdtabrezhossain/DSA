class RemoveTheLastSetBit {
    public static void main(String[] args) {
        int number = 40;
        System.out.println("Before: " + Integer.toBinaryString(number));

        number &= number - 1;
        System.out.println("After: " + Integer.toBinaryString(number));
    }
}
