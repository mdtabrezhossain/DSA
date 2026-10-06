import java.util.Stack;

class ReverseLinkedList {
    ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        head = stack.pop();

        current = head;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            current.next = node;

            current = node;
        }

        current.next = null;

        return head;
    }

    ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode current = head;

        while (current != null) {
            ListNode after = current.next;

            current.next = before;

            before = current;
            current = after;
        }

        return before;
    }
}