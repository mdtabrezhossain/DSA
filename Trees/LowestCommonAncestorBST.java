class LowestCommonAncestorBST {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        return helper(root, p, q);
    }

    TreeNode helper(TreeNode root, TreeNode a, TreeNode b) {
        if (a.val < root.val && b.val < root.val)
            return helper(root.left, a, b);

        else if (a.val > root.val && b.val > root.val)
            return helper(root.right, a, b);

        else
            return root;
    }

    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}