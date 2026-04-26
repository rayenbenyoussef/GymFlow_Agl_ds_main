import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    public static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========== GymFlow - Menu Principal ==========");
            System.out.println("1. Se connecter (Login)");
            System.out.println("2. S'inscrire (Register)");
            System.out.println("3. Quitter (Exit)");
            System.out.print("Choisissez une option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                
                    break;
                case "2":
                    break;
                case "3":
                    handleExit();
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }


    private void handleExit() {
        System.out.println("Au revoir !");
        scanner.close();
    }

    public static void main(String[] args) {
        new Main().displayMenu();
    }
}