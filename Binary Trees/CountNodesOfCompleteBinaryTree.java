import java.lang.Math;

class CountNodesOfCompleteBinaryTree {
    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // perfect binary tree
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight)) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    int getLeftHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    int getRightHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}