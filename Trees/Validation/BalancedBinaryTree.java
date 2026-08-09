class BalancedBinaryTree {
    boolean isBalanced(TreeNode root) {
        return helper(root)[0] == 1;
    }

    int[] helper(TreeNode root) {
        if (root == null)
            return new int[] { 1, 0 };

        int[] leftResult = helper(root.left);
        int[] rightResult = helper(root.right);

        boolean areSubTreesBalanced = leftResult[0] == 1 && rightResult[0] == 1;
        boolean isBalanced = areSubTreesBalanced
                && (Math.abs(leftResult[1] - rightResult[1]) <= 1);

        int height = 1 + Math.max(leftResult[1], rightResult[1]);

        return new int[] { isBalanced ? 1 : 0, height };
    }
}