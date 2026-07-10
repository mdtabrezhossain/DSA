class ReorderList {
    ListNode left;

    void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ArrayList<ListNode> nodes = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int i = 0;
        int j = nodes.size() - 1;

        ListNode a;
        ListNode b;

        while (i < j) {
            a = nodes.get(i);
            b = nodes.get(j);

            a.next = b;

            i++;

            a = nodes.get(i);
            b.next = a;

            j--;
        }

        a = nodes.get(i);
        a.next = null;
    }

    void reorderList2(ListNode head) {
        left = head;
        helper(left);
    }

    void helper(ListNode right) {
        if (right == null)
            return;

        helper(right.next);

        if (left == null)
            return;

        if (left == right || left.next == right) {
            right.next = null;
            left = null;

            return;
        }

        right.next = left.next;
        left.next = right;

        left = right.next;
    }
}