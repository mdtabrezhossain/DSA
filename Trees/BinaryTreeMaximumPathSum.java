class BinaryTreeMaximumPathSum {
    int maxPathSum(TreeNode root) {
        int[] result = new int[] { root.val };
        helper(root, result);
        return result[0];
    }

    int helper(TreeNode root, int[] result) {
        if (root == null)
            return 0;

        int leftMax = helper(root.left, result);
        leftMax = Math.max(leftMax, 0);

        int rightMax = helper(root.right, result);
        rightMax = Math.max(rightMax, 0);

        result[0] = Math.max(result[0], leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
    }
}