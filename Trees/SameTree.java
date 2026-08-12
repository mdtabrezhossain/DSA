class SameTree {
    boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        if (node1.val != node2.val)
            return false;

        return isSameTree(node1.left, node2.left)
                && isSameTree(node1.right, node2.right);
    }

    boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { p, q });

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            if (node1 == null && node2 == null)
                continue;

            if (node1 == null || node2 == null)
                return false;

            if (node1.val != node2.val)
                return false;

            stack.push(new TreeNode[] { node1.left, node2.left });
            stack.push(new TreeNode[] { node1.right, node2.right });
        }

        return true;
    }
}

// Note:
// Recursive: here, if (node1 == null && node2 == null) return true = this
// subtree is valid.
// Iterative: here, if (node1 == null && node2 == null) continue = this node
// pair is valid. Keep checking the rest
