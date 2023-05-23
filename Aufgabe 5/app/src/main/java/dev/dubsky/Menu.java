package dev.dubsky;

/**
 * @author Clemens Maas
 * @since 2023-05-22
 */
public class Menu {

    private static Menu instance;

    enum MenuOption {
        INSERT, MODIFY, DELETE, PRINT_PRE_ORDER, PRINT_IN_ORDER, EXIT
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
        System.out.println("1. INSERT");
        System.out.println("2. MODIFY");
        System.out.println("3. DELETE");
        System.out.println("4. PRINT_PRE_ORDER");
        System.out.println("5. PRINT_IN_ORDER");
        System.out.println("6. EXIT");
        return MenuOption.values()[Integer.parseInt(System.console().readLine()) - 1];
    }

    /**
     * Starts the menu.
     */
    public void start() {
        Node t = new Node("ROOT");
        MenuOption option = MenuOption.INSERT;
        while (option != MenuOption.EXIT) {
            option = getInput();
            switch (option) {
                case INSERT -> {
                    System.out.println("Insert a new node:");
                    t.insert(t, System.console().readLine());
                }
                case DELETE -> {
                    System.out.println("Delete a node: ");
                    t.delete(t, System.console().readLine());
                }
                case PRINT_PRE_ORDER -> {
                    System.out.println("--- Printing tree: ---");
                    t.printTree_pre_order(t);
                }
                case PRINT_IN_ORDER -> {
                    System.out.println("--- Printing tree: ---");
                    t.printTree_in_order(t);
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
