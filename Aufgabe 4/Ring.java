import java.util.Scanner;

/**
 * @author Clemens Maas
 * @matrikelnummer 1260892
 */
public class Ring {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    public Ring(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        buffer[tail] = element;
        tail = tail + 1;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        }
        int element = buffer[head];
        head = head + 1;
        size--;
        return element;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        int i = head;
        while (i != tail) {
            System.out.print(buffer[i] + " ");
            i = i + 1;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter capacity of queue: ");
        int capacity = scanner.nextInt();
        Ring queue = new Ring(capacity);
        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Is Empty");
            System.out.println("4. Print Contents");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                }
                case 2 -> {
                    int dequeuedElement = queue.dequeue();
                    System.out.println("Dequeued element: " + dequeuedElement);
                }
                case 3 -> {
                    System.out.println("Is empty: " + queue.isEmpty());
                }
                case 4 -> {
                    queue.print();
                }
                case 5 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}
