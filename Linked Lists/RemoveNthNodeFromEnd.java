class RemoveNthNodeFromEnd {
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
        }

        if (n == length)
            return head.next;

        int targetPos = length - n;

        current = head;
        int pos = 1;

        while (pos < targetPos) {
            current = current.next;
            pos++;
        }

        current.next = current.next.next;

        return head;
    }

    ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode a = head;
        ListNode b = head;

        int gap = 0;

        while (gap < n) {
            b = b.next;
            gap++;
        }

        if (b == null)
            return head.next;

        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        a.next = a.next.next;

        return head;
    }
}