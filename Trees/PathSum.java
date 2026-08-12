class PathSum {
    boolean result = false;

    boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0);
        return result;
    }

    void helper(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result = true;
            }

            return;
        }

        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
    }
}