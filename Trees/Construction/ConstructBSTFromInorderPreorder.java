class ConstructBSTFromInorderPreorder {
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();
    int preorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <= inorder.length - 1; i++) {
            int value = inorder[i];
            inorderIdxMap.put(value, i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int value = preorder[preorderIdx];
        TreeNode node = new TreeNode(value);
        preorderIdx++;

        int inorderIdx = inorderIdxMap.get(value);
        node.left = helper(preorder, start, inorderIdx - 1);
        node.right = helper(preorder, inorderIdx + 1, end);

        return node;
    }
}