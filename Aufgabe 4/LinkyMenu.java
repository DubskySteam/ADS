import java.util.Scanner;

public class LinkyMenu {
    
    private LinkyList list = new LinkyList();
    private Scanner scanner = new Scanner(System.in);

    private enum Menu {
        N,
        L,
        Z,
        e,
        s,
        l,
        m,
        X
    }

    private char readInput() {
        System.out.print("Enter Option >> ");
        return scanner.nextLine().charAt(0);
    }

    private String readLine() {
        System.out.print("Enter String >> ");
        return scanner.nextLine();
    }

    private void followUp() {
        for(Menu m : Menu.values()) {
            System.out.println(m.name());
        }
    }

    private void select(char x) {
        switch(x) {
            case 'N' -> {
                list = new LinkyList();
                System.out.println("List was created/reset");
            }
            case 'L' -> {
                list = null;
                System.out.println("List was deleted");
            }
            case 'Z' -> {
                if(list != null) {
                    list.print();
                } else {
                    System.out.println("List is null");
                }
            }
            case 'e' -> {
                if(list != null) {
                    list.insert(readLine());
                } else {
                    System.out.println("List is null");
                }
            }
            case 's' -> {
                if(list != null) {
                    list.search(readLine());
                } else {
                    System.out.println("List is null");
                }
            }
            case 'l' -> {
                if(list != null) {
                    list.remove();
                } else {
                    System.out.println("List is null");
                }
            }
            case 'm' -> {
                if(list != null) {
                    list.modify(readLine());
                } else {
                    System.out.println("List is null");
                }
            }
            case 'X' -> {
                scanner.close();
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid Option");
            }
        }
    }

    public void run() {
        System.out.println("--- OPTIONS ---");
        followUp();
        while(true) {
            select(readInput());
        }
    }

}
