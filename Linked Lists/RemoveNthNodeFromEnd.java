class RemoveNthNodeFromEnd {
    ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int idx = nodes.size() - n;

        if (idx == 0)
            return head.next;

        nodes.get(idx - 1).next = nodes.get(idx).next;

        return head;
    }
}