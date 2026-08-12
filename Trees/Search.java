class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        while (root != null) {
            if (root.value < val) {
                root = root.right;
            } else if (root.value > val) {
                root = root.left;
            } else if (root.value == val) {
                return root;
            }
        }

        return null;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}