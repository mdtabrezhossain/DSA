class GoodNumber {
    double countGoodNumbers(int n) {
        int noOfOddIndices = n / 2;
        int noOfEvenIndices = (n + 1) / 2;

        return Math.pow(4, noOfOddIndices) * Math.pow(5, noOfEvenIndices);
    }
}
