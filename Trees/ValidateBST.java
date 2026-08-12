class ValidateBST {
    boolean result = true;
    Integer prevNodeVal = null;

    boolean isValidBST(TreeNode root) {
        helper(root);
        return result;
    }

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (prevNodeVal != null && node.val <= prevNodeVal) {
            result = false;
            return;
        }

        prevNodeVal = node.val;
        helper(node.right);
    }
}