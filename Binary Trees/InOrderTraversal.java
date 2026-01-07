import java.util.Stack;

class InOrderTraversal {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        System.out.println(root.value + " ");
        traverse(root.right);
    }

    void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pop();
                System.out.println(node.value);

                node = node.right;
            }
        }
    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
