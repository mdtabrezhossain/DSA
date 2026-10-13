class MaximumDepthOfBinaryTree {
    int maxDepth(TreeNode root) {
        return helper(root);
    }

    int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        int maxDepth = 1 + Math.max(leftDepth, rightDepth);

        return maxDepth;
    }

    int maxDepth2(TreeNode root) {
        Stack<SimpleEntry<TreeNode, Integer>> stack = new Stack<>();

        if (root != null)
            stack.push(new SimpleEntry<>(root, 1));

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            SimpleEntry<TreeNode, Integer> pair = stack.pop();

            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            maxDepth = Math.max(maxDepth, depth);

            if (node.left != null)
                stack.push(new SimpleEntry<>(node.left, depth + 1));

            if (node.right != null)
                stack.push(new SimpleEntry<>(node.right, depth + 1));
        }

        return maxDepth;
    }

    int maxDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            depth++;
        }

        return depth;
    }
}