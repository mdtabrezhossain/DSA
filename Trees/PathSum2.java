import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class PathSum {
    List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>(), pathList);
        return pathList;
    }

    void helper(TreeNode root, int targetSum, int currentSum, List<Integer> currentPath, List<List<Integer>> pathList) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                pathList.add(new ArrayList<>(currentPath));
            }

            currentPath.remove(currentPath.size() - 1);
            return;
        }

        helper(root.left, targetSum, currentSum, currentPath, pathList);
        helper(root.right, targetSum, currentSum, currentPath, pathList);

        currentSum -= root.val;
        currentPath.remove(currentPath.size() - 1);
    }
}