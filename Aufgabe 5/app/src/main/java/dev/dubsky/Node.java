package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Node {
    public String value;
    public Node left, right;
    int height;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public Node(String value, Node left, Node right) {
        this(value);
        this.left = left;
        this.right = right;
        this.height = Math.max(left.height, right.height) + 1;
    }

    public boolean is_empty() {
        return this.value == null;
    }

    /**
     * Gets the height of the node.
     * @param node Node to get the height of
     * @return Height of the node
     */
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    public Node bin(String value, Node left, Node right) {
        return new Node(value, left, right);
    }
}
