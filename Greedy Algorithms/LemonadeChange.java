class LemonadeChange {
    public static void main(String[] args) {
        int[] cashGiven = { 5, 5, 10, 10, 20 };

        int rupees5Count = 0;
        int rupees10Count = 0;
        boolean areAllCustomersServed = true;

        for (int cg : cashGiven) {
            if (cg == 5) {
                rupees5Count++;

            } else if (cg == 10) {
                if (rupees5Count == 0) {
                    areAllCustomersServed = false;
                    break;
                }

                rupees5Count--;
                rupees10Count++;

            } else if (cg == 20) {
                if (rupees10Count > 0 && rupees5Count > 0) {
                    rupees10Count--;
                    rupees5Count--;
                } else if (rupees5Count >= 3) {
                    rupees5Count -= 3;
                } else {
                    areAllCustomersServed = false;
                    break;
                }
            }
        }

        System.out.println("Are all customers served?: " + areAllCustomersServed);
    }
}
