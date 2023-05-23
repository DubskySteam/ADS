package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Menu {

    private static Menu instance;

    enum MenuOption {
        INSERT, SEARCH, MODIFY, PRINT_PRE_ORDER, PRINT_IN_ORDER, EXIT
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    /**
     * Prints the menu and returns the selected option.
     * @return Selected option
     */
    public MenuOption getInput() {
        System.out.println("Choose an option:");
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Print");
        System.out.println("4. Exit");
        return MenuOption.values()[Integer.parseInt(System.console().readLine()) - 1];
    }

    /**
     * Starts the menu.
     */
    public void start() {
        Node t = new Node("Finn");
        MenuOption option = MenuOption.INSERT;
        while (option != MenuOption.EXIT) {
            option = getInput();
            switch (option) {
                case INSERT -> {
                    System.out.println("Insert a new node:");
                    t.insert(System.console().readLine());
                }
                case SEARCH -> {
                    System.out.println("Search for a node: ");
                    Node n = t.search(t.root, System.console().readLine());
                    if (n != null) {
                        System.out.println("Found node with value " + n.value);
                    } else {
                        System.out.println("Node not found");
                    }
                }
                case PRINT_PRE_ORDER -> {
                    System.out.println("Printing tree:");
                    t.print_pre_order();
                }
                case PRINT_IN_ORDER -> {
                    System.out.println("Printing tree:");
                    t.print_in_order();
                }
                case EXIT -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> throw new IllegalArgumentException("Unexpected value: " + option);
            }
        }
    }

}
