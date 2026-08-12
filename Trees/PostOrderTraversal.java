import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PostOrderTraversal {
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        System.out.println(root.value + " ");
    }

    void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);

            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value + " ");
        }

        return;
    }

    void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            root = stack.peek();

            if (root.right != null && lastVisited != root.right) {
                current = root.right;
            } else {
                System.out.println(root.value + " ");
                lastVisited = stack.pop(); // lastVisited = root
            }
        }

        return;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}