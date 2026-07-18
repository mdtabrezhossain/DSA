import java.util.HashMap;

import org.w3c.dom.Node;

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

    Node copyRandomList3(Node head) {
        if (head == null)
            return null;

        Node current = head;
        Node temp = null;
        Node copy = null;

        while (current != null) {
            temp = current.next;

            copy = new Node(current.val);
            current.next = copy;

            copy.next = temp;
            current = temp;
        }

        current = head;

        while (current != null) {
            copy = current.next;

            if (current.random != null)
                copy.random = current.random.next;

            current = current.next.next;
        }

        current = head;
        Node newHead = head.next;

        while (current != null) {
            copy = current.next;

            temp = copy.next;
            current.next = temp;

            if (temp != null)
                copy.next = temp.next;

            current = temp;
        }

        return newHead;
    }
}