class BinaryTreeRightSideView {
    List<Integer> rightSideView(TreeNode root) {
        ArrayList result = new ArrayList<>();
        helper(root, result, 1);
        return result;
    }

    void helper(TreeNode root, ArrayList<Integer> result, int depth) {
        if (root == null)
            return;

        if (depth > result.size())
            result.add(root.val);

        helper(root.right, result, depth + 1);
        helper(root.left, result, depth + 1);
    }

    List<Integer> rightSideView(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelOrder = levelOrder(root);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < levelOrder.size(); i++) {
            ArrayList<Integer> level = levelOrder.get(i);
            int last = level.get(level.size() - 1);
            result.add(last);
        }

        return result;
    }
}
