class RecoverBST {
    TreeNode previousNode = null;
    TreeNode target1 = null;
    TreeNode target2 = null;

    void recoverTree(TreeNode root) {
        helper(root);

        int temp = target1.val;
        target1.val = target2.val;
        target2.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (previousNode != null && previousNode.val > root.val) {
            if (target1 == null) {
                target1 = previousNode;
            }

            target2 = root;
        }

        previousNode = root;
        helper(root.right);
    }
}

class RecoverBST2 {
    TreeNode previousNode = null;
    TreeNode target1 = null;
    TreeNode target2 = null;

    void recoverTree(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode current = root.left;

                while (current.right != null && current.right != root) {
                    current = current.right;
                }

                if (current.right == null) {
                    current.right = root;
                    root = root.left;
                } else {
                    current.right = null;
                    check(root);
                    root = root.right;
                }
            } else {
                check(root);
                root = root.right;
            }
        }

        int temp = target1.val;
        target1.val = target2.val;
        target2.val = temp;
    }

    private void check(TreeNode root) {
        if (previousNode != null && root.val < previousNode.val) {
            if (target1 == null) {
                target1 = previousNode;
            }
            target2 = root;
        }

        previousNode = root;
    }
}
