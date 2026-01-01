class PowXN {

    static double calcPow(double number, long power) {

        // when power is zero
        if (power == 0) {
            return 1;
        }

        // when power is negative
        if (power < 0) {
            return calcPow(1 / number, -power);
        }

        // when power is positive and even
        if (power % 2 == 0) {
            return calcPow(number * number, power / 2);
        }

        // when power is positive and odd
        else {
            return number * calcPow(number * number, (power - 1) / 2);
        }
    }
}