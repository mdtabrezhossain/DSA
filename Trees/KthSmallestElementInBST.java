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

    int kthSmallest(TreeNode root, int k) {
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;

                while (predecessor.right != null && predecessor.right != root)
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    k--;

                    if (k == 0)
                        return root.val;

                    root = root.right;
                }
            } else {
                k--;

                if (k == 0)
                    return root.val;

                root = root.right;
            }
        }

        return -1;
    }
}