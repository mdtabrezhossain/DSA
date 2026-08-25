class ConstructTreeFromPreorderAndInorderTraversal {
    int preIdx = 0;
    HashMap<Integer, Integer> map;

    TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i <= inorder.length - 1; i++)
            map.put(inorder[i], i);

        return helper(preorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;

        int inIdx = map.get(root.val);

        root.left = helper(preorder, start, inIdx - 1);
        root.right = helper(preorder, inIdx + 1, end);

        return root;
    }
}