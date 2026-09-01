class TaskScheduler {
    int leastInterval(char[] tasks, int cooldown) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : tasks)
            frequencyMap.put(
                    c, frequencyMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        maxHeap.addAll(frequencyMap.entrySet());

        int interval = 0;

        while (!maxHeap.isEmpty()) {
            int slots = cooldown + 1;
            ArrayList<Map.Entry<Character, Integer>> coolDownBuffer = new ArrayList<>();

            while (slots > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                int frequency = entry.getValue();

                frequency--;
                interval++;
                slots--;

                entry.setValue(frequency);

                if (frequency > 0)
                    coolDownBuffer.add(entry);
            }

            maxHeap.addAll(coolDownBuffer);

            if (!maxHeap.isEmpty())
                interval += slots;
        }

        return interval;
    }
}
