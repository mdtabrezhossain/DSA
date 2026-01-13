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
