class LowestCommonAncestorBST {
    TreeNode result = null;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            helper(root, p, q);
        } else {
            helper(root, q, p);
        }

        return result;
    }

    void helper(TreeNode node, TreeNode targetNode1, TreeNode targetNode2) {
        if (node == null) {
            return;
        }

        if (node == targetNode1 || node == targetNode2) {
            result = node;
            return;
        }

        if (node.val < targetNode1.val) {
            helper(node.right, targetNode1, targetNode2);
        } else if (node.val > targetNode2.val) {
            helper(node.left, targetNode1, targetNode2);
        } else {
            result = node;
            return;
        }
    }
}