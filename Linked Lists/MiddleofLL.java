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

class LL {
    static class ListNode {
        int value;
        ListNode nextNode;

        ListNode(int value) {
            this.value = value;
            this.nextNode = null;
        }
    }

    ListNode headNode = null;

    void createLL(int[] array) {
        headNode = new ListNode(array[0]);
        ListNode currentNode = headNode;

        for (int i = 1; i <= array.length - 1; i++) {
            currentNode.nextNode = new ListNode(array[i]);
            currentNode = currentNode.nextNode;
        }
    }

    void printLL() {
        ListNode tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.nextNode;
        }

        System.out.println("null");
    }
}
