class ReverseNodesInkGroup {
    ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int i = 0;
        while (i + k - 1 < nodes.size()) {
            int left = i;
            int right = i + k - 1;

            while (left < right) {
                ListNode a = nodes.get(left);
                ListNode b = nodes.get(right);

                nodes.set(left, b);
                nodes.set(right, a);

                a.next = null;

                left++;
                right--;
            }

            i += k;
        }

        for (i = 0; i < nodes.size() - 1; i++) {
            ListNode a = nodes.get(i);
            ListNode b = nodes.get(i + 1);

            a.next = b;
        }

        return nodes.get(0);
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode newHead = null;
        ListNode previousGroupTail = null;
        ListNode currentGroupHead = head;

        while (currentGroupHead != null) {
            ListNode currentGroupTail = currentGroupHead;

            for (int i = 1; i <= k + 1; i++) {
                if (currentGroupTail == null)
                    break;

                currentGroupTail = currentGroupTail.next;
            }

            if (currentGroupTail == null) {
                if (previousGroupTail != null)
                    previousGroupTail.next = currentGroupHead;

                break;
            }

            ListNode nextGroupHead = currentGroupTail.next;

            reverse(currentGroupHead, currentGroupTail);

            if (newHead == null)
                newHead = currentGroupTail;

            if (previousGroupTail != null)
                previousGroupTail.next = currentGroupTail;

            currentGroupHead.next = nextGroupHead;

            previousGroupTail = currentGroupHead;
            currentGroupHead = nextGroupHead;
        }

        return newHead;
    }

    void reverse(ListNode head, ListNode tail) {
        ListNode stop = tail.next;
        ListNode previous = stop;
        ListNode current = head;

        while (current != stop) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }
}
