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

    /**
     * Checks if the node is empty.
     * @return True if the node is empty, false otherwise
     */
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

    /**
     * Returns a new tree node with the given value.
     * @param value Value of the node
     * @param left Left child
     * @param right Right child
     * @return New tree node
     */
    public Node bin(String value, Node left, Node right) {
        return new Node(value, left, right);
    }
}
