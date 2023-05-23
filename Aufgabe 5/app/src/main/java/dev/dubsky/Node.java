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
     * Inserts a new node into the tree.
     * @param root Root node
     * @param value Value of the node to insert
     * @return Root node
     */
    public Node insert(Node root, String value) {
        if (root == null) {
            return new Node(value);
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insert(root.right, value);
        } else {
            System.out.println("Value already exists in the tree.");
        }
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    public Node modify(Node root, String oldValue, String newValue) {
        root = delete(root, oldValue);
        root = insert(root, newValue);
        return root;
    }

    public Node delete(Node root, String value) {
        if (root == null) {
            return null;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = delete(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node minNode = findMin(root.right);
                root.value = minNode.value;
                root.right = delete(root.right, minNode.value);
            }
        }
        if (root == null) {
            return null;
        }
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    public Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
