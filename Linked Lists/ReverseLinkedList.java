class ReverseLinkedList {
    ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        ListNode current = head;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();

            current.next = node;
            current = node;
        }

        current.next = null;
        return head;
    }

    ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reversedHead;
    }

    ListNode reverseList3(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }
}