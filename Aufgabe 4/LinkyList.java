/**
 * @author Clemens Maas
 * @matrikelnummer 1260892
 */
public class LinkyList {

    Node head;
    Node current;

    public LinkyList() {
        this.head = null;
        this.current = null;
    }

    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    void insert(String data) {
        if(this.head == null) {
            this.head = new Node(data);
        } else {
            current = this.head;
            while(this.current.next != null) {
                this.current = this.current.next;
            }
            this.current.next = new Node(data);
            this.current = this.head;
        }
    }
    
    void setNextElem(Node node) {
        Node next = this.getNextElem();
        node.next = next;
        this.current.next = node;
    }

    Node getNextElem() {
        return this.current.next;
    }

    void removeNextElem(Node node) {
        if(node.next != null && node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
    }

    void setPrevElem(Node node) {
        Node prev = this.getPrevElem();
        prev.next = node;
        prev.next.next = this.current;
    }

    Node getPrevElem() {
        Node prev = this.head;
        while(prev.next != this.current) {
            prev = prev.next;
        }
        return prev;
    }

    void modify(String data) {
        this.current.data = data;
    }

    void remove() {
        if(this.current == this.head) {
            this.head = this.head.next;
            this.current = this.head;
        } else {
            Node prev = this.getPrevElem();
            prev.next = this.current.next;
            this.current = prev;
        }
    }

    void search(String criteria) {
        this.current = this.head;
        while(this.current != null) {
            if(this.current.data.equals(criteria)) {
                String prev = "null";
                String next = "null";
                if(this.head != this.current && getPrevElem() != null) {
                    prev = getPrevElem().data;
                }
                if(getNextElem() != null) {
                    next = getNextElem().data;
                }
                System.out.printf("Found %s >>> [Prev: %s] [Next: %s]\n", this.current.data, prev, next);
                return;
            }
            this.current = this.current.next;
        }
        this.current = this.head;
        System.out.println("No match found");
    }

    public void print() {
        Node ohead = this.head;
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        head = ohead;
    }

}