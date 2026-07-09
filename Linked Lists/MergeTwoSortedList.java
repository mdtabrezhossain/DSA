class MergeTwoSortedList {
    ListNode mergeTwoLists(ListNode i, ListNode j) {
        if (i == null && j == null)
            return null;

        if (i == null)
            return j;

        if (j == null)
            return i;

        ListNode start;
        ListNode end;

        if (i.val <= j.val) {
            start = i;
            end = i;

            i = i.next;
        } else {
            start = j;
            end = j;

            j = j.next;
        }

        while (i != null && j != null) {
            if (i.val <= j.val) {
                end.next = i;
                end = i;

                i = i.next;
            } else {
                end.next = j;
                end = j;

                j = j.next;
            }
        }

        if (i == null) {
            end.next = j;
        } else {
            end.next = i;
        }

        return start;
    }
}