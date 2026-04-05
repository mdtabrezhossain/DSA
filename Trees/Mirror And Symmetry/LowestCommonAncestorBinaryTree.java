class Solution {
    TreeNode result = null;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        countTargetsInSubtree(root, p, q);
        return result;
    }

    int countTargetsInSubtree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return 0;

        int targetsInLeftSubtree = countTargetsInSubtree(node.left, p, q);
        int targetsInRightSubtree = countTargetsInSubtree(node.right, p, q);

        int isCurrentTarget = (node == p || node == q) ? 1 : 0;

        int totalTargetsFound = targetsInLeftSubtree + targetsInRightSubtree + isCurrentTarget;

        if (totalTargetsFound == 2 && result == null) {
            result = node;
        }

        return totalTargetsFound;
    }
}