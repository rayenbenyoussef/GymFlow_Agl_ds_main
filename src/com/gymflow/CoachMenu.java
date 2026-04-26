

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachMenu {

    private Scanner scanner = new Scanner(System.in);
    private Coach coach;

    // Temporary storage (you can replace with DB later)
    private List<Adherent> adherents = new ArrayList<>();
    private List<Programme> programmes = new ArrayList<>();

    public CoachMenu(Coach coach) {
        this.coach = coach;
    }
    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU COACH =====");
            System.out.println("1. Créer un programme d'entraînement");
            System.out.println("2. Voir les adhérents");
            System.out.println("3. Ajouter un exercice à un programme");
            System.out.println("4. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    voirAdherents();
                    break;
                case "3":
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // ✅ 1. Create program
    
    // ✅ 2. Show adherents
    private void voirAdherents() {
        if (adherents.isEmpty()) {
            System.out.println("Aucun adhérent.");
            return;
        }

        for (int i = 0; i < adherents.size(); i++) {
            System.out.println(i + " - " + adherents.get(i).getNom());
        }
    }

    // ✅ 3. Add exercise
    

}