import java.util.LinkedList;
import java.util.Queue;

class ValidateBST {
    boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, long lowerBound, long upperBound) {
        if (root == null)
            return true;

        if (lowerBound < root.val && root.val < upperBound)
            return helper(root.left, lowerBound, root.val)
                    && helper(root.right, root.val, upperBound);

        return false;
    }

    boolean isValidBST2(TreeNode root) {
        Queue<Pair<TreeNode, long[]>> queue = new LinkedList<>();

        if (root != null)
            queue.offer(new Pair<>(
                    root,
                    new long[] { Long.MIN_VALUE, Long.MAX_VALUE }));

        while (!queue.isEmpty()) {
            Pair<TreeNode, long[]> current = queue.poll();

            TreeNode node = current.getKey();
            long lowerBound = current.getValue()[0];
            long upperBound = current.getValue()[1];

            if (node.val <= lowerBound || node.val >= upperBound)
                return false;

            if (node.left != null)
                queue.offer(
                        new Pair<>(
                                node.left,
                                new long[] { lowerBound, node.val }));

            if (node.right != null)
                queue.offer(
                        new Pair<>(
                                node.right,
                                new long[] { node.val, upperBound }));
        }

        return true;
    }
}