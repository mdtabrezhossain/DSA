class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        while (root != null) {
            if (root.left != null) {
                TreeNode currentNode = root.left;

                while (currentNode.right != null && currentNode.right != root) {
                    currentNode = currentNode.right;
                }

                if (currentNode.right == null) {
                    currentNode.right = root;
                    root = root.left;
                } else {
                    currentNode.right = null;

                    resultList.add(root.val);
                    root = root.right;
                }

            } else {
                resultList.add(root.val);
                root = root.right;
            }
        }

        return resultList;
    }
}