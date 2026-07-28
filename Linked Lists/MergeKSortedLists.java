class MergeKSortedLists {
    ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();

        for (ListNode head : lists) {
            while (head != null) {
                nodes.add(head.val);
                head = head.next;
            }
        }

        if (nodes.size() == 0)
            return null;

        Collections.sort(nodes);

        ListNode head = new ListNode(nodes.get(0));
        ListNode current = head;

        for (int i = 1; i < nodes.size(); i++) {
            int val = nodes.get(i);
            current.next = new ListNode(val);

            current = current.next;
        }

        return head;
    }

    ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode newHead = null;

        for (ListNode head : lists)
            newHead = merge(newHead, head);

        return newHead;
    }

    ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1) {
            ListNode[] newLists = new ListNode[(lists.length + 1) / 2];

            for (int i = 0; i < lists.length; i += 2) {
                ListNode head1 = lists[i];
                ListNode head2 = (i + 1) < lists.length ? lists[i + 1] : null;

                ListNode newHead = merge(head1, head2);

                newLists[i / 2] = newHead;
            }

            lists = newLists;
        }

        return lists[0];
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        ListNode newHead;

        if (head1.val <= head2.val) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }

        ListNode tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        tail.next = (head1 != null) ? head1 : head2;

        return newHead;
    }
}
