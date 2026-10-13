class LowestCommonAncestorBST {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        return helper(root, a, b);
    }

    TreeNode helper(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return null;

        if (a.val < root.val && b.val < root.val)
            return helper(root.left, a, b);

        if (a.val > root.val && b.val > root.val)
            return helper(root.right, a, b);

        return root;
    }

    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode a, TreeNode b) {
        while (root != null) {
            if (a.val < root.val && b.val < root.val)
                root = root.left;

            else if (a.val > root.val && b.val > root.val)
                root = root.right;

            return root;
        }

        return null;
    }
}