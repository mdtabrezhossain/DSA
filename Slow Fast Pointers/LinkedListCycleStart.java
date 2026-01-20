class LinkedListCycleStart {
    ListNode getCycleStart(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                break;
            }
        }

        if (fastPointer == null || fastPointer.next == null) {
            return null;
        }

        ListNode tempPointer = head;
        while (tempPointer != slowPointer) {
            tempPointer = tempPointer.next;
            slowPointer = slowPointer.next;
        }

        return tempPointer;
    }
}

/*
 * Intuition :--
 * 
 * Let:
 * d1 = distance from head to the start of the cycle
 * d2 = distance from the start of the cycle to the meeting point
 * c = length of the cycle
 *
 * Distance travelled by slow pointer = d1 + d2
 * Distance travelled by fast pointer = 2(d1 + d2)
 *
 * Fast pointer also travels:
 * d1 + d2 + n*c
 * where n is the number of full cycles completed by fast.
 *
 * Therefore:
 * 2(d1 + d2) = d1 + d2 + n*c
 * d1 + d2 = n*c
 * d1 = n*c - d2
 *
 * This means d1 is equal to the remaining distance in the cycle.
 *
 * Hence, if one pointer starts from the head and another starts
 * from the meeting point of slow and fast pointer, and both move one step at a
 * time,
 * they will meet at the start of the cycle.
 */
