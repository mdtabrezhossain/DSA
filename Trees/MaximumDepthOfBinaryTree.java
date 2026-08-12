class MaximumDepthOfBinaryTree {
    int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int maxLeftHeight = maxDepth(root.left);
        int maxRightHeight = maxDepth(root.right);
        int maxHeight = Math.max(maxLeftHeight, maxRightHeight);

        return 1 + maxHeight;
    }

    int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        int maxHeight = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> entry = stack.pop();
            TreeNode node = entry.getKey();
            int height = entry.getValue();

            maxHeight = Math.max(maxHeight, height);

            if (node.left != null)
                stack.push(new Pair<>(node.left, height + 1));

            if (node.right != null)
                stack.push(new Pair<>(node.right, height + 1));
        }

        return maxHeight;
    }
}