import java.util.Stack;

class PreOrderTraversal {
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value + " ");
        traverse(root.left);
        traverse(root.right);
    }

    void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.value + " ");

            if (root.right != null) {
                stack.push(root.right);

            }

            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
