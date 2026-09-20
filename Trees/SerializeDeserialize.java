class SerializeDeserialize {
    String serialize(TreeNode root) {
        if (root == null)
            return "$";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root == null) {
                result.append("$,");
                continue;
            }

            result.append(root.val).append(',');
            queue.offer(root.left);
            queue.offer(root.right);
        }

        return result.toString();
    }

    TreeNode deserialize(String data) {
        if (data.equals("$"))
            return null;

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!values[i].equals("$")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            if (i < values.length && !values[i].equals("$")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}