class RemoveDuplicatedFromSortedList {
    ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode i = head;
        ListNode j = head.next;
        int previousValue = head.value;

        while (j != null) {
            if (j.val != previousValue) {
                i.next = j;
                i = j;
                previousValue = j.value;
            }

            j = j.next;
        }

        // cut off remaining list
        i.next = null;

        return head;
    }
}