import java.lang.Math;

class DiameterOfTree {

    // Diameter = number of edges in the longest path between any two nodes
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;

    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // get height left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // get diameter passing from the current node
        diameter = Math.max(leftHeight + rightHeight, diameter);

        // return height of the longest subtree to the parent including its connecting
        // edge to the
        // current node
        return Math.max(leftHeight, rightHeight) + 1;

    }
}