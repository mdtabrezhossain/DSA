class InvertTree {
    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swapChildren(root);

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    TreeNode invertTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            swapChildren(current);

            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }

        return root;
    }
}