class CloneGraph {
    HashMap<Node, Node> clones;

    Node cloneGraph(Node node) {
        if (node == null)
            return null;

        clones = new HashMap<>();

        return helper(node);
    }

    Node helper(Node node) {
        if (clones.containsKey(node))
            return clones.get(node);

        Node clone = new Node(node.val);
        clones.put(node, clone);

        for (Node neighbor : node.neighbors)
            clone.neighbors.add(helper(neighbor));

        return clone;
    }
}