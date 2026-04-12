class RecoverBST {
    TreeNode previousNode = null;
    TreeNode target1 = null;
    TreeNode target2 = null;

    void recoverTree(TreeNode root) {
        helper(root);

        int temp = target1.val;
        target1.val = target2.val;
        target2.val = temp;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (previousNode != null && previousNode.val > root.val) {
            if (target1 == null) {
                target1 = previousNode;
            }

            target2 = root;
        }

        previousNode = root;
        helper(root.right);
    }
}
