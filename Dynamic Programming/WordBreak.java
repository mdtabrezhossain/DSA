import java.util.*;

class WordBreak {
    String text;
    HashSet<String> dictionary;

    Boolean[] results;

    boolean wordBreak(String text, List<String> dictionary) {
        this.dictionary = new HashSet<>(dictionary);
        this.text = text;
        results = new Boolean[text.length()];

        return helper(0);
    }

    boolean helper(int start) {
        if (start == text.length())
            return true;

        if (results[start] != null)
            return results[start];

        for (int end = start + 1; end <= text.length(); end++) {
            String part = text.substring(start, end);

            if (dictionary.contains(part) && helper(end)) {
                results[start] = true;

                return true;
            }
        }

        results[start] = false;

        return false;
    }

    boolean wordBreak(String text, List<String> words) {
        HashSet<String> dictionary = new HashSet<>(words);

        boolean[] results = new boolean[text.length() + 1];
        results[0] = true;

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (results[j] && dictionary.contains(text.substring(j, i))) {
                    results[i] = true;
                    break;
                }
            }
        }

        return results[text.length()];
    }
}