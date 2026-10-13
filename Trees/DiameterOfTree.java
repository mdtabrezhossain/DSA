class DiameterOfTree {
    int diameter;

    int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;

        getHeight(root);
        return diameter;
    }

    int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        int currentHeight = 1 + Math.max(leftHeight, rightHeight);

        return currentHeight;
    }

    int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;

        Map<TreeNode, Integer> heights = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !heights.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !heights.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();

                int leftHeight = heights.getOrDefault(node.left, 0);
                int rightHeight = heights.getOrDefault(node.right, 0);

                diameter = Math.max(diameter, leftHeight + rightHeight);

                int currentHeight = 1 + Math.max(leftHeight, rightHeight);
                heights.put(node, currentHeight);
            }
        }

        return diameter;
    }
}