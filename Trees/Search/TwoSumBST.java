import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TwoSumBST {
    boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> sortedList = getSortedListFromBST(root);
        int left = 0;
        int right = sortedList.size() - 1;

        while (left < right) {
            int sum = sortedList.get(left) + sortedList.get(right);
            if (sum == k) {
                return true;

            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    ArrayList<Integer> getSortedListFromBST(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                resultList.add(root.val);

                root = root.right;
            }
        }

        return resultList;
    }

    boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator leftPtr = new BSTIterator(root, false);
        BSTIterator rightPtr = new BSTIterator(root, true);

        int leftVal = leftPtr.next();
        int rightVal = rightPtr.next();

        while (leftVal < rightVal) {
            int sum = leftVal + rightVal;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                leftVal = leftPtr.next();
            } else {
                rightVal = rightPtr.next();
            }
        }

        return false;
    }
}

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverseOrder;

    BSTIterator(TreeNode root, boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
        pushAll(root);
    }

    int next() {
        TreeNode node = stack.pop();

        if (!reverseOrder) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }

        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);

            if (!reverseOrder) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}