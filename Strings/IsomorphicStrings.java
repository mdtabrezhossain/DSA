import java.util.HashMap;

class IsomorphicStrings {
    public static void main(String[] args) {
        String word1 = "badc";
        String word2 = "baba";
        boolean areIsomorphicStrings = true;

        if (word1.length() != word2.length()) {
            System.out.println("Isomorphic strings?: " + areIsomorphicStrings);
            return;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i <= word1.length() - 1; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if ((map1.containsKey(c1) && map1.get(c1) != c2)
                    || (map2.containsKey(c2) && map2.get(c2) != c1)) {
                areIsomorphicStrings = false;
                break;

            } else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        System.out.println("Isomorphic strings?: " + areIsomorphicStrings);
    }
}
