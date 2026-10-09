class MergeTwoSortedList {
    ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return null;

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        ArrayList<Integer> values = new ArrayList<>();
        ListNode current = head1;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        current = head2;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        values.sort(null);
        // Collections.sort(values);

        ListNode head = new ListNode(values.get(0));
        current = head;

        for (int i = 1; i < values.size(); i++) {
            ListNode node = new ListNode(values.get(i));

            current.next = node;
            current = node;
        }

        return head;
    }

    ListNode mergeTwoLists2(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return null;

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        ListNode a = head1;
        ListNode b = head2;

        ListNode head = null;

        if (a.val <= b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }

        ListNode current = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                current = a;

                a = a.next;
            } else {
                current.next = b;
                current = b;

                b = b.next;
            }
        }

        if (a == null)
            current.next = b;
        else
            current.next = a;

        return head;
    }
}