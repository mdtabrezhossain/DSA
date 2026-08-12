class DiameterOfTree {

    // Diameter = number of edges in the longest path between any two nodes
    int diameter = 0;

    int diameterOfBinaryTree(TreeNode root) {
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

    int diameterOfBinaryTree2(TreeNode root) {
        int diameter = 0;

        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        Map<TreeNode, Integer> height = new HashMap<>();

        if (root != null)
            stack.push(new Pair<>(root, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> entry = stack.pop();
            TreeNode node = entry.getKey();
            boolean visited = entry.getValue();

            if (!visited) {
                stack.push(new Pair<>(node, true));

                if (node.left != null)
                    stack.push(new Pair<>(node.left, false));

                if (node.right != null)
                    stack.push(new Pair<>(node.right, false));
            } else {
                int leftHeight = height.getOrDefault(node.left, 0);
                int rightHeight = height.getOrDefault(node.right, 0);

                diameter = Math.max(diameter, leftHeight + rightHeight);

                int currentHeight = 1 + Math.max(leftHeight, rightHeight);
                height.put(node, currentHeight);
            }
        }

        return diameter;
    }
}