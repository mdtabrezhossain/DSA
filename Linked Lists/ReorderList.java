import java.util.ArrayList;

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
        if (head == null)
            return null;

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

    void reorderList3(ListNode head) {
        if (head == null)
            return;

        ListNode a = head;

        ListNode middle = middleOfList(head);
        ListNode b = reverseList(middle);

        ListNode c = null;
        ListNode d = null;

        while (a.next != null && b.next != null) {
            c = a.next;
            d = b.next;

            a.next = b;
            b.next = c;

            a = c;
            b = d;
        }
    }

    ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode before = null;
        ListNode current = head;
        ListNode after = null;

        while (current != null) {
            after = current.next;
            current.next = before;

            before = current;
            current = after;
        }

        return before;
    }

    ListNode middleOfList(ListNode head) {
        if (head == null)
            return null;

        ListNode i = head;
        ListNode j = head;

        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }

        return i;
    }
}