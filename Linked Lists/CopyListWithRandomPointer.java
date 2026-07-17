class CopyListWithRandomPointer {
    Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            map.put(current, copy);

            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = map.get(current);

            copy.next = map.get(current.next);
            copy.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }

    Node copyRandomList2(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        while (current != null) {
            map.putIfAbsent(current, new Node(current.val));

            Node copy = map.get(current);

            if (current.next != null) {
                map.putIfAbsent(current.next, new Node(current.next.val));
                copy.next = map.get(current.next);
            }

            if (current.random != null) {
                map.putIfAbsent(current.random, new Node(current.random.val));
                copy.random = map.get(current.random);
            }

            current = current.next;
        }

        return map.get(head);
    }

}