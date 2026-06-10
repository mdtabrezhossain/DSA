class TimeMap {
    private HashMap<String, ArrayList<Map.Entry<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        Map.Entry<Integer, String> entry = Map.entry(timestamp, value);
        ArrayList<Map.Entry<Integer, String>> entries = map.get(key);

        entries.add(entry);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        return search(key, timestamp);
    }

    private String search(String key, int targetTimestamp) {
        ArrayList<Map.Entry<Integer, String>> entries = map.get(key);
        int start = 0;
        int end = entries.size() - 1;
        String value = "";

        while (start <= end) {
            int mid = start + (end - start) / 2;

            Map.Entry<Integer, String> entry = entries.get(mid);
            int timestamp = entry.getKey();

            if (timestamp == targetTimestamp) {
                return entry.getValue();
            }

            if (timestamp <= targetTimestamp) {
                start = mid + 1;
                value = entry.getValue();
            } else {
                end = mid - 1;
            }
        }

        return value;
    }
}
