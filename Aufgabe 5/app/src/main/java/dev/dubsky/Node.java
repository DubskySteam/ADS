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

    public Node bin(String value, Node left, Node right) {
        return new Node(value, left, right);
    }
}
