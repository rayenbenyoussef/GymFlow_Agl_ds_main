
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdherentMenu {

    private Scanner scanner = new Scanner(System.in);
    private Adherent adherent;

    private List<Reservation> reservations = new ArrayList<>();
    private GestionnaireProgramme gestionnaireProgramme = new GestionnaireProgramme();
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
                    voirProgramme();
                    
                    break;
                case "7":       
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }




    // ================= PROGRAMME =================

    private void voirProgramme() {

    // 🔍 récupérer le programme via gestionnaire
    Programme p = gestionnaireProgramme.trouverProgramme(adherent.getId());

    if (p == null) {
        System.out.println("Aucun programme.");
        return;
    }

    System.out.println("\n=== MON PROGRAMME ===");
    System.out.println("Objectif: " + p.getObjectif());

    List<Exercice> exs = p.getExercices();

    if (exs.isEmpty()) {
        System.out.println("Aucun exercice.");
        return;
    }

    for (int i = 0; i < exs.size(); i++) {
        Exercice e = exs.get(i);

        String status = e.isTermines() ? "✔" : "❌";

        System.out.println(i + " - " + e.getNom() + " | "
                + e.getSeries() + "x" + e.getRepetitions()
                + " | " + status);
    }

    System.out.print("Marquer exercice terminé (index ou -1): ");
    int index = Integer.parseInt(scanner.nextLine());

    if (index != -1) {
        boolean ok = gestionnaireProgramme.terminerExercice(adherent.getId(), index);

        if (ok) {
            System.out.println("Exercice terminé !");
        } else {
            System.out.println("Erreur.");
        }
    }
}

}