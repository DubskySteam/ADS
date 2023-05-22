package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    boolean isEmpty() {
        return this.root == null;
    }

    public void insert(String value) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            Node current = this.root;
            while (current != null) {
                if (value.compareTo(current.value) < 0) {
                    if (current.left == null) {
                        current.left = new Node(value);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new Node(value);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node search(Node node, String s) {
        if (node == null) {
            return null;
        } else if (node.value.equals(s)) {
            return node;
        } else if (s.compareTo(node.value) < 0) {
            return search(node.left, s);
        } else {
            return search(node.right, s);
        }
    }

    public void delete(String value) {
        Node toDelete = search(this.root, value);
        if (toDelete != null) {
            if (toDelete.left == null && toDelete.right == null) {
                // No children
                System.out.println("No children");
                toDelete = null;
            } else if (toDelete.left != null && toDelete.right == null) {
                // Only left child
                toDelete = toDelete.left;
            } else if (toDelete.left == null && toDelete.right != null) {
                // Only right child
                toDelete = toDelete.right;
            } else {
                // Both children
                Node current = toDelete.right;
                while (current.left != null) {
                    current = current.left;
                }
                toDelete.value = current.value;
                current = null;
            }
        }
    }

    public void modify(String oldValue, String newValue) {
        Node toModify = search(this.root, oldValue);
        if (toModify != null) {
            toModify.value = newValue;
        }
    }

    public void print() {
        // Left tree
        print(this.root.left);
        // Root
        System.out.print(this.root.value + " ");
        // Right tree
        print(this.root.right);

        System.out.println();
    }

    public void print(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            // Left tree
            print(node.left);
            // Right tree
            print(node.right);
        }
    }
}