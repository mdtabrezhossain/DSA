import java.util.Queue;

class CheckCompletenessOfBinaryTree {
    boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isNullSeen = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                isNullSeen = true;
            } else {
                if (isNullSeen) {
                    return false;
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        return true;
    }
}