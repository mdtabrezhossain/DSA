class ValidParenthesis {
    static boolean isValid(String s) {
        StringBuilder temp = new StringBuilder(s);
        boolean flag = true;

        while (flag) {
            flag = false;

            if (containsPair(temp, '(', ')')) {
                temp = removePair(temp, '(', ')');
                flag = true;
            }
            if (containsPair(temp, '[', ']')) {
                temp = removePair(temp, '[', ']');
                flag = true;
            }
            if (containsPair(temp, '{', '}')) {
                temp = removePair(temp, '{', '}');
                flag = true;
            }
        }

        return temp.isEmpty();
    }

    static boolean containsPair(StringBuilder str, char x, char y) {
        for (int i = 0; i <= str.length() - 2; i++) {
            if (str.charAt(i) == x && str.charAt(i + 1) == y) {
                return true;
            }
        }

        return false;
    }

    static StringBuilder removePair(StringBuilder str, char x, char y) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i <= str.length() - 1) {
            if (i <= str.length() - 2
                    && str.charAt(i) == x && str.charAt(i + 1) == y) {
                i += 2;
            } else {
                result.append(str.charAt(i));
                i++;
            }
        }

        return result;
    }

    static boolean isValid2(String string) {
        while (string.contains("()")
                || string.contains("{}")
                || string.contains("[]")) {
            string = string.replace("()", "");
            string = string.replace("{}", "");
            string = string.replace("[]", "");
        }

        return string.isEmpty();
    }
}