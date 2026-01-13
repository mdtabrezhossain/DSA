public class MiddleofLL {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        LL list = new LL();
        list.createLL(array);
        list.printLL();

        // // Approach 1 ---
        // LL.ListNode tempNode = list.headNode;
        // int listSize = 0;

        // while (tempNode != null) {
        // listSize++;
        // tempNode = tempNode.nextNode;
        // }

        // tempNode = list.headNode;
        // for (int count = 1; count <= (listSize / 2); count++) {
        // tempNode = tempNode.nextNode;
        // }

        // System.out.println("Middle element: " + tempNode.value);

        // Approach 2 ---
        LL.ListNode fastPointer = list.headNode;
        LL.ListNode slowPointer = list.headNode;

        while (fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }

        System.out.println("Middle element: " + slowPointer.value);
    }
}
