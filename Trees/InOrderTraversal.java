import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> inorderTraversalLeetcode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

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
                result.add(node.val);

                node = node.right;
            }
        }

        return result;
    }

    List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        helper(node, result);
        return result;
    }

    void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        helper(node.left, result);
        result.add(node.value);
        helper(node.right, result);
    }
}