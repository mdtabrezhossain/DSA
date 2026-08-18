class KthSmallestElementInBST {
    int kthSmallest(TreeNode root, int k) {
        return helper(root, k)[0];
    }

    int[] helper(TreeNode root, int k) {
        if (root == null)
            return new int[] { -1, k };

        int[] leftResult = helper(root.left, k);

        if (leftResult[0] != -1)
            return leftResult;

        k = leftResult[1] - 1;

        if (k == 0)
            return new int[] { root.val, 0 };

        return helper(root.right, k);
    }
}