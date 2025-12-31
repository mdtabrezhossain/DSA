import java.util.HashMap;

class RomanNumberConversion {
    public static void main(String[] args) {
        String romanNumber = "MCMXCIV";
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i <= romanNumber.length() - 1; i++) {
            int currentValue = map.get(romanNumber.charAt(i));

            if (i < romanNumber.length() - 1) {
                int nextValue = map.get(romanNumber.charAt(i + 1));

                if (currentValue >= nextValue) {
                    result += currentValue;
                } else {
                    result -= currentValue;
                }
            } else {
                result += currentValue;
            }
        }

        System.out.printf("%s: %d", romanNumber, result);
    }
}
