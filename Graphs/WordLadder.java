class WordLadder {
    HashSet<String> choices;
    Queue<String> queue;

    int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordExist(endWord, wordList))
            return 0;

        choices = new HashSet<>();

        for (String word : wordList)
            choices.add(word);

        queue = new LinkedList<>();
        queue.offer(beginWord);
        choices.remove(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                String word = queue.poll();

                if (word.equals(endWord))
                    return count;

                addChoices(word);
                levelSize--;
            }

            count++;
        }

        return 0;
    }

    void addChoices(String word) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char current = letters[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == current)
                    continue;

                letters[i] = c;
                String choice = new String(letters);

                if (choices.contains(choice)) {
                    queue.offer(choice);
                    choices.remove(choice);
                }
            }

            letters[i] = current;
        }
    }

    boolean wordExist(String target, List<String> words) {
        for (String word : words)
            if (word.equals(target))
                return true;

        return false;
    }
}