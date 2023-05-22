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

    public void search(Node node, String s) {
        if (node != null) {
            if (node.value.equals(s)) {
                System.out.println("Found: " + node.value);
            } else {
                search(node.left, s);
                search(node.right, s);
            }
        }
    }

    public void print() {
        // Left tree
        print(this.root.left);
        // Root
        System.out.print(this.root.value + " ");
        // Right tree
        print(this.root.right);
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
