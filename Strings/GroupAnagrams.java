import java.util.ArrayList;
import java.util.HashMap;

class GroupAnagrams {
    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> anagramsMap = new HashMap<>();
        for (String s : strs) {
            String k = getFrequencyString(s);

            if (anagramsMap.containsKey(k)) {
                anagramsMap.get(k).add(s);
            } else {
                ArrayList<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                anagramsMap.put(k, anagrams);
            }
        }

        result.addAll(anagramsMap.values());
        return result;
    }

    public String getFrequencyString(String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= count.length - 1; i++) {
            if (count[i] != 0) {
                result.append((char) (i + 'a'));
                result.append(count[i]);
            }
        }

        return result.toString();
    }
}
