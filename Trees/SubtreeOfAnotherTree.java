class SubtreeOfAnotherTree {
    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        StringBuilder tree = new StringBuilder();
        StringBuilder subTree = new StringBuilder();

        preOrder(root, tree);
        preOrder(subRoot, subTree);

        return tree.toString().contains(subTree.toString());
    }

    void preOrder(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("x,");
            return;
        }

        result.append(root.val).append(",");

        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}
