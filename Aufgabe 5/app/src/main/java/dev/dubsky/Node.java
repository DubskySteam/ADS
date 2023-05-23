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

    /**
     * Searches for a node with the given value.
     * Will then delete the node and insert a new node with the new value.
     * Old approach: Modify the value of the node.
     * New approach: Delete the node and insert a new node with the new value.
     * @param root Root node
     * @param oldValue Old value
     * @param newValue New value
     * @return Root node
     */
    public Node modify(Node root, String oldValue, String newValue) {
        root = delete(root, oldValue);
        root = insert(root, newValue);
        return root;
    }

    /**
     * Deletes a node with the given value.
     * @param root Root node
     * @param value Value of the node to delete
     * @return Root node
     */
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

    /**
     * Finds the minimum node in the tree.
     * @param root Root node
     * @return Minimum node
     */
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
     * Prints the tree in pre-order.
     * @param root Root node
     */
    public void printTree_pre_order(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "(h" + root.height + ") : ");
        System.out.print((root.left != null ? root.left.value + "(h" + root.left.height + ")" : "null") + ", ");
        System.out.print((root.right != null ? root.right.value + "(h" + root.right.height + ")" : "null"));
        System.out.println();
        printTree_pre_order(root.left);
        printTree_pre_order(root.right);
    }

    /**
     * Prints the tree in in-order.
     * @param root Root node
     */
    public void printTree_in_order(Node root) {
        if (root == null) {
            return;
        }
        printTree_in_order(root.left);
        System.out.println(root.value);
        printTree_in_order(root.right);
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
