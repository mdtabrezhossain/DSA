class SymmetricTree {
    boolean isSymmetric(TreeNode root) {
        TreeNode node1 = root;
        TreeNode node2 = root;

        return isSameTree(node1, node2);
    }

    boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        boolean isLeftRightSame = isSameTree(node1.left, node2.right);
        boolean isRightLeftSame = isSameTree(node1.right, node2.left);

        return isLeftRightSame && isRightLeftSame;
    }
}
