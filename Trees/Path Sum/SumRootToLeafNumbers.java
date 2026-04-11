class SumRootToLeafNumbers {
    int totalSum = 0;

    int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum;
    }

    void helper(TreeNode root, int rootToLeafPath) {
        if (root == null) {
            return;
        }

        rootToLeafPath = rootToLeafPath * 10 + root.val;

        if (root.left == null && root.right == null) {
            totalSum += rootToLeafPath;
            return;
        }

        helper(root.left, rootToLeafPath);
        helper(root.right, rootToLeafPath);
    }
}