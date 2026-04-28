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
    public static GestionnaireReservation gestionnaire = new GestionnaireReservation();
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

                    gestionnaire.afficherToutesSeances();
                    break;
                case "2":
                    gestionnaire.reserverSeance(adherent.getId(), 0);
                    break;
                case "3":
                    
                    annulerReservation();
                    break;
                

                case "4":
                    voirAbonnement();
                    
                    break;
                case "5":
                    choisirAbonnement();
                    
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

    

    // ================= CANCEL =================

    public Seance findSeanceById(int idSeance) {
        for (Seance s : gestionnaire.getSeances()) {
            if (s.getId() == idSeance) {
                return s;
            }
        }
        return null;
    }
    private void annulerReservation() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.println(i + " - " + findSeanceById(r.getIdSeance()).getNom() + " | " + findSeanceById(r.getIdSeance()).getType());
        }

        System.out.print("Choisir réservation: ");
        int index = Integer.parseInt(scanner.nextLine());

        Reservation r = reservations.get(index);

        if (findSeanceById(r.getIdSeance()).getHeure().minusHours(1).isBefore(LocalDateTime.now())) {
            System.out.println("Impossible d'annuler (moins de 1h).");
            return;
        }

        findSeanceById(r.getIdSeance()).annulerPlace();
        reservations.remove(index);

        System.out.println("Réservation annulée !");
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

    


    // ================= ABONNEMENT =================

    private void voirAbonnement() {
        Abonnement a = adherent.getAbonnement();

        if (a == null) {
            System.out.println("Aucun abonnement.");
            return;
        }

        a.afficherDetails(); // ✅ much better
    }

    private void choisirAbonnement() {
    if (adherent == null) {
        System.out.println("Erreur: aucun adherent connecté.");
        return;
    }

    Abonnement current = adherent.getAbonnement();

    // 🚫 Prevent override if active
    if (current != null && current.estValide()) {
        System.out.println("Vous avez déjà un abonnement actif !");
        current.afficherDetails();
        return;
    }

    System.out.println("\n1. Mensuel - 50 DT");
    System.out.println("2. Trimestriel - 130 DT");
    System.out.println("3. Annuel - 450 DT");

    String choice = scanner.nextLine();

    Abonnement a = null;

    switch (choice) {
        case "1":
            a = new Abonnement(1, adherent.getId(), "Mensuel", "Actif");
            break;
        case "2":
            a = new Abonnement(2, adherent.getId(), "Trimestriel", "Actif");
            break;
        case "3":
            a = new Abonnement(3, adherent.getId(), "Annuel", "Actif");
            break;
        default:
            System.out.println("Choix invalide.");
            return;
    }

    adherent.setAbonnement(a);
    System.out.println("✓ Nouvel abonnement activé !");
}


}