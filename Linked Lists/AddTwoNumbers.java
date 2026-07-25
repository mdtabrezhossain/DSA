class AddTwoNumbers {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;

        ListNode newHead = null;
        ListNode prev = null;

        int carry = 0;

        while (i != null || j != null || carry != 0) {
            int val1 = (i != null) ? i.val : 0;
            int val2 = (j != null) ? j.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            ListNode k = new ListNode(sum % 10);

            i = (i != null) ? i.next : null;
            j = (j != null) ? j.next : null;

            if (newHead != null) {
                prev.next = k;
            } else {
                newHead = k;
            }

            prev = k;
        }

        return newHead;
    }
}