/**
 * @author Clemens Maas
 * @matrikelnummer 1260892
 */
public class Listen {

    Node head;
    Node tail;
    int listSize;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

        Node (String data, Node next) {
            this.data = data;
            this.next = next;
        }

        void setNextElem(Node next) {
            this.next = next;
        }

        Node getNextElem() {
            return this.next;
        }

        void removeNextElem() {
            this.next = null;
        }

        void setPrevElem(Node prev) {
            this.next = prev;
        }

        Node getPrevElem() {
            return this.next;
        }
    }

    public static void main(String[] args) {
        
    }

}