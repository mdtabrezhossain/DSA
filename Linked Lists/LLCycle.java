public class LLCycle {
    boolean hasCycle(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode node = head;

        while (node != null) {
            int val = node.val;

            if (set.contains(val))
                return true;

            set.add(val);
            node = node.next;
        }

        return false;
    }

    boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;
    }
}
