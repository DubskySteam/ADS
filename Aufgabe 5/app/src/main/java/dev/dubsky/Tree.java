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




    /**
     * Inserts a new node into the tree.
     * Key is the value of the node.
     * To guarantee the tree is sorted, the value is compared to the current node.
     * Lexicographically smaller values are inserted to the left, bigger ones to the right.
     * @param value
     */
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

    /**
     * Searches for a node with the given value.
     * @param node Current node
     * @param s Value to search for
     * @return
     */
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

    /**
     * Deletes a node with the given value.
     * @param value Value to delete
     */
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

    /**
     * Traverses the tree in pre-order and prints the values of the nodes.
     * Kickstarts the recursive function.
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    /**
     * Traverses the tree in pre-order and prints the values of the nodes.
     * @param node Current node
     */
    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     * Modifies a node with the given value.
     * @param oldValue Value to modify
     * @param newValue New value
     */
    public void modify(String oldValue, String newValue) {
        Node toModify = search(this.root, oldValue);
        if (toModify != null) {
            toModify.value = newValue;
        }
    }


}