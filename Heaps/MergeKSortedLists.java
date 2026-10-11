class MergeKSortedLists {
    ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> values = new ArrayList<>();

        for (ListNode head : lists) {
            ListNode current = head;

            while (current != null) {
                values.add(current.val);
                current = current.next;
            }
        }

        values.sort(null);
        // Collections.sort(values);

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode current = temp;

        for (int val : values) {
            ListNode node = new ListNode(val);
            current.next = node;

            current = node;
        }

        return temp.next;
    }

    ListNode mergeKLists2(ListNode[] lists) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode current = temp;

        while (true) {
            ListNode min = null;
            int minIdx = -1;

            for (int i = 0; i < lists.length; i++) {
                ListNode head = lists[i];

                if (head == null)
                    continue;

                if (min == null || head.val < min.val) {
                    min = head;
                    minIdx = i;
                }
            }

            if (min == null)
                break;

            current.next = min;
            current = min;

            lists[minIdx] = lists[minIdx].next;
        }

        return temp.next;
    }

    ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode head : lists)
            if (head != null)
                minHeap.offer(head);

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode current = temp;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();

            current.next = min;
            current = min;

            if (min.next != null) {
                min = min.next;
                minHeap.offer(min);
            }
        }

        return temp.next;
    }
}
