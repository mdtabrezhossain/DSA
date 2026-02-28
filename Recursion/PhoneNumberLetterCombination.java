import java.util.ArrayList;
import java.util.HashMap;

class PhoneNumberLetterCombination {
    static ArrayList<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }

        HashMap<Character, String> digitToLettersMap = new HashMap<>();
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");

        ArrayList<String> resultList = new ArrayList<>();
        helper(digits, digitToLettersMap, resultList, new StringBuilder(), 0);

        return resultList;
    }

    static void helper(
            String digits,
            HashMap<Character, String> digitToLetters,
            ArrayList<String> resultList,
            StringBuilder combination,
            int idx) {
        if (idx == digits.length()) {
            resultList.add(combination.toString());
            return;
        }

        String choices = digitToLetters.get(digits.charAt(idx));
        for (char choice : choices.toCharArray()) {
            combination.append(choice);
            helper(digits, digitToLetters, resultList, combination, idx + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}