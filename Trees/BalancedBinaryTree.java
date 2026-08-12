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

    boolean isBalanced2(TreeNode root) {
        if (root == null)
            return true;

        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        Map<TreeNode, int[]> map = new HashMap<>();

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
                int[] leftInfo = map.getOrDefault(node.left, new int[] { 1, 0 });
                int[] rightInfo = map.getOrDefault(node.right, new int[] { 1, 0 });

                boolean isLeftBalanced = leftInfo[0] == 1;
                boolean isRightBalanced = rightInfo[0] == 1;
                boolean areSubTreesBalanced = isLeftBalanced && isRightBalanced;

                int leftHeight = leftInfo[1];
                int rightHeight = rightInfo[1];
                int height = 1 + Math.max(leftHeight, rightHeight);

                boolean isBalanced = areSubTreesBalanced && (Math.abs(leftHeight - rightHeight) <= 1);

                int[] info = { isBalanced ? 1 : 0, height };

                map.put(node, info);
            }
        }

        return map.get(root)[0] == 1;
    }
}