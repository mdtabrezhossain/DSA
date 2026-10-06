class LinkedListCycle {
    boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            if (set.contains(current))
                return true;

            set.add(current);
            current = current.next;
        }

        return false;
    }

    boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}