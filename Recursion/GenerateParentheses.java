import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    static List<String> generateParenthesis(int n) {
        List<String> resuList = new ArrayList<>();

        helper(n, 0, 0, new StringBuilder(), resuList);

        return resuList;
    }

    static void helper(
            int n,
            int openingBracketCount,
            int closingBracketCount,
            StringBuilder tempStr,
            List<String> resultList) {
        if (openingBracketCount == n
                && closingBracketCount == n) {
            resultList.add(tempStr.toString());
            return;
        }

        if (openingBracketCount < n) {
            tempStr.append('(');
            helper(n, openingBracketCount + 1, closingBracketCount, tempStr, resultList);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }

        if (closingBracketCount < openingBracketCount) {
            tempStr.append(')');
            helper(n, openingBracketCount, closingBracketCount + 1, tempStr, resultList);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }

        return;
    }
}