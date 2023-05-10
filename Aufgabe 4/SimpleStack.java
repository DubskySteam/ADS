import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Clemens Maas
 * @matrikelnummer 1260892
 */
public class SimpleStack {

    private Scanner scanner = new Scanner(System.in);
    Stack stack = new Stack();

    enum Options {
        PUSH,
        POP,
        TOP,
        PRINT,
        EXIT
    }

    int readInput() {
        System.out.print("Enter Option >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    String readString() {
        System.out.print("Enter String >> ");
        return scanner.nextLine();
    }

    void printMenu() {
        System.out.println("--- OPTIONS ---");
        int i = 0;
        for(Options o : Options.values()) {
            System.out.printf("%d) " + o.name()+"\n", i);
            i++;
        }
    }

    void close() {
        scanner.close();
        System.exit(0);
    }

    public class Stack {
        List<String> stack = new LinkedList<>();

        void push(String s) {
            stack.add(s);
        }

        String pop() {
            return stack.remove(stack.size() - 1);
        }

        String top() {
            return stack.get(stack.size() - 1);
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        void print() {
            for(String s : stack) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        SimpleStack ss = new SimpleStack();
        while (true) {
            ss.printMenu();
            switch (ss.readInput()) 
            {
                case 0 -> {
                    ss.stack.push(ss.readString());
                }
                case 1 -> {
                    ss.stack.pop();
                }
                case 2 -> {
                    System.out.println("--- TOP ---");
                    System.out.println(ss.stack.top());
                }
                case 3 -> {
                    System.out.println("--- STACK ---");
                    ss.stack.print();
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    ss.close();
                }
            }
        }
    }
    
}
