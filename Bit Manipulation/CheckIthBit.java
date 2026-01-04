class CheckIthBit {
    public static void main(String[] args) {
        int number = 13;
        int bitNumber = 2;

        // // Approach 1 ---
        // String binaryString = Integer.toBinaryString(number);

        // if (binaryString.charAt(binaryString.length() - 1 - bitNumber) == '1') {
        // System.out.println("The ith bit is set");
        // }else{
        // System.out.println("The ith bit is not set");
        // }

        // Approach 2 ---
        if ((number & (1 << bitNumber)) != 0) {
            System.out.println("The ith bit is set");
        } else {
            System.out.println("The ith bit is not set");
        }

    }
}