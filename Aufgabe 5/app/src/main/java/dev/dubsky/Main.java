package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Main {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert("F");
        t.insert("D");
        t.insert("B");
        t.insert("E");
        t.insert("A");
        t.insert("C");
        t.insert("J");
        t.insert("K");
        t.insert("H");
        t.insert("G");
        t.insert("I");
        t.preOrderTraversal();
    }
    
}
