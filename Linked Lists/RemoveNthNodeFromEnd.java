import java.util.ArrayList;

class RemoveNthNodeFromEnd {
    int N;

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

    ListNode removeNthFromEnd2(ListNode head, int n) {
        N = n;
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (node == null)
            return null;

        node.next = helper(node.next);

        N--;

        if (N == 0)
            return node.next;

        return node;
    }

    ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int targetPos = length - n + 1;

        if (targetPos == 1)
            return head.next;

        current = head;

        for (int pos = 1; pos <= targetPos - 2; pos++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode i = head;
        ListNode j = i;

        for (int k = 1; k <= n; k++)
            j = j.next;

        if (j == null)
            return head.next;

        while (j.next != null) {
            i = i.next;
            j = j.next;
        }

        i.next = i.next.next;

        return head;
    }
}