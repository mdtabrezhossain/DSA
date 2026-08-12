class Ceil {
    int getCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.value == key) {
                return root.value;
            }

            else if (root.value > key) {
                ceil = root.value;
                root = root.left;
            }

            else if (root.value < key) {
                root = root.right;
            }
        }

        return ceil;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
