class ValidateBST {
    boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val <= min)
            return false;

        if (root.val >= max)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }

    TreeNode prev = null;

    boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;

        if (!isValidBST(root.left))
            return false;

        if (prev != null && root.val <= prev.val)
            return false;

        prev = root;

        return isValidBST(root.right);
    }

    boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (prev != null && current.val <= prev.val)
                return false;

            prev = current;
            current = current.right;
        }

        return true;
    }
}