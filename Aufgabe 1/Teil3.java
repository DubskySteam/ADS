import java.util.Scanner;

/**
 * @author Clemens Maas
 * @Matrikelnummer 1260892
 * @date 19.04.2023
 */
public class Teil3 {

    public static void main(String[] args) {
        boolean running = true;
        Scanner s = new Scanner(System.in);
        while(running) {
            System.out.println("Bitte geben Sie den Pfad zur Datei an: ");
            String path = s.nextLine();      
            Summarizer summarizer = new Summarizer(path);
            summarizer.start();
            System.out.println("Wollen Sie eine weitere Datei einlesen? (y/n)");
            String input = s.nextLine();
            if(input.equals("n")) {
                running = false;
            }
        }
        s.close();
        System.exit(0);
    }

}