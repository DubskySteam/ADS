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
        m
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
            }
            case 'L' -> {
                
            }
            case 'Z' -> {
                
            }
            case 'e' -> {
                
            }
            case 's' -> {
                
            }
            case 'l' -> {
                
            }
            case 'm' -> {
                
            }
        }
    }

    public void run() {
        System.out.println("--- OPTIONS ---");
        followUp();
        select(readInput());
    }

}
