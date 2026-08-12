import java.util.HashMap;

import javax.swing.tree.TreeNode;

class ConstructBSTFromInorderPreorder {
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();
    int preorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <= inorder.length - 1; i++) {
            int value = inorder[i];
            inorderIdxMap.put(value, i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode constructSubtree(int[] preorder, int inorderStartIdx, int inorderEndIdx) {
        if (inorderStartIdx > inorderEndIdx) {
            return null;
        }

        int value = preorder[preorderIdx];
        TreeNode node = new TreeNode(value);
        preorderIdx++;

        int nodeIdx = inorderIdxMap.get(value);
        node.left = constructSubtree(preorder, inorderStartIdx, nodeIdx - 1);
        node.right = constructSubtree(preorder, nodeIdx + 1, inorderEndIdx);

        return node;
    }
}

// Note : preorder decides who is the current root and inorder decides who
// belong to the left and right subtree.