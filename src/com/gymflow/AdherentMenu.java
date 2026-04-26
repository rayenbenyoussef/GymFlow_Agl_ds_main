import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdherentMenu {

    private Scanner scanner = new Scanner(System.in);
    private Adherent adherent;

    private List<Reservation> reservations = new ArrayList<>();
    public AdherentMenu(Adherent adherent) {
        this.adherent = adherent;
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU ADHERENT =====");
            System.out.println("1. Voir les séances disponibles");
            System.out.println("2. réserver une séance");
            System.out.println("3. Annuler une réservation");
            System.out.println("4. Voir mon abonnement");
            System.out.println("5. Choisir un abonnement");
            System.out.println("6. Voir mon programme");
            System.out.println("7. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    
                    break;
                case "4":
                    
                    break;
                case "5":
                    
                    break;
                    
                case "6":
                    
                    break;
                case "7":       
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }




}