class CountGoodNodesInBinaryTree {
    int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    int helper(TreeNode root, int max) {
        if (root == null)
            return 0;

        if (root.val >= max) {
            return 1
                    + helper(root.left, root.val)
                    + helper(root.right, root.val);
        }

        return helper(root.left, max) + helper(root.right, max);
    }

    int goodNodes2(TreeNode root) {
        int result = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        if (root != null)
            queue.offer(new Pair<>(root, root.val));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();

            TreeNode node = pair.getKey();
            int max = pair.getValue();

            if (node.val >= max) {
                result++;
                max = node.val;
            }

            if (node.left != null)
                queue.offer(new Pair<>(node.left, max));

            if (node.right != null)
                queue.offer(new Pair<>(node.right, max));
        }

        return result;
    }
}