class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("Before --");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("\nAfter --");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
