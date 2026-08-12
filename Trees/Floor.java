public class Floor {
    int getFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.value == key) {
                return root.value;
            }

            else if (root.value < key) {
                floor = root.value;
                root = root.right;
            }

            else if (root.value > key) {
                root = root.left;
            }
        }

        return floor;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
