import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class levelOrderTraversal {
    ArrayList<ArrayList<Integer>> breadthFirstTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.value);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
