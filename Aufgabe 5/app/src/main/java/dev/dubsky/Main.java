package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Main {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert("D");
        t.insert("B");
        t.insert("A");
        t.insert("C");
        t.insert("E");
        t.print();
        //t.delete("E");
        t.modify("E", "G");
        t.print();
    }
    
}
