import java.util.HashMap;

class LRUCache {
    ArrayList<int[]> list;
    int capacity;

    LRUCache(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    int get(int key) {
        for (int i = 0; i < list.size(); i++) {
            int[] pair = list.get(i);
            int currentKey = pair[0];

            if (currentKey == key) {
                int value = pair[1];

                list.remove(i);
                list.add(pair);

                return value;
            }
        }

        return -1;
    }

    void put(int key, int value) {
        for (int i = 0; i < list.size(); i++) {
            int[] pair = list.get(i);
            int currentKey = pair[0];

            if (currentKey == key) {
                list.remove(i);
                break;
            }
        }

        if (list.size() == capacity) {
            list.remove(0);
        }

        int[] pair = new int[] { key, value };
        list.add(pair);
    }
}

class DLLNode {
    int key;
    int value;

    DLLNode next;
    DLLNode prev;

    DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache2 {
    int capacity;

    HashMap<Integer, DLLNode> map;

    DLLNode head;
    DLLNode tail;
    int listSize;

    LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = null;
        tail = null;
        listSize = 0;
    }

    int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DLLNode node = map.get(key);

        removeNode(node);
        insertNodeAtFront(node);

        return node.value;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);
            node.value = value;

            removeNode(node);
            insertNodeAtFront(node);
            return;
        }

        if (listSize == capacity) {
            map.remove(tail.key);
            removeNode(tail);
            listSize--;
        }

        DLLNode node = new DLLNode(key, value);

        map.put(key, node);
        insertNodeAtFront(node);
        listSize++;
    }

    void removeNode(DLLNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    void insertNodeAtFront(DLLNode node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }
    }
}