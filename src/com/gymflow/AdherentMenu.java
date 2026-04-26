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
                    gestionnaire.reserverSeance(adherent.getId(), 0, null)
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



    // ================= ABONNEMENT =================

    private void voirAbonnement() {
        Abonnement a = adherent.getAbonnement();

        if (a == null) {
            System.out.println("Aucun abonnement.");
            return;
        }

        System.out.println("Type: " + a.getType());
        System.out.println("Expire le: " + a.getDateFin());
    }

    private void choisirAbonnement() {
        System.out.println("\n1. Journalier - 10 DT");
        System.out.println("2. Mensuel - 100 DT");
        System.out.println("3. Annuel - 800 DT");

        String choice = scanner.nextLine();

        Abonnement a = null;

        switch (choice) {
            case "1":
                a = new Abonnement(1,adherent.getId(),"Journalier", "Actif");
                break;
            case "2":
                a = new Abonnement(2,adherent.getId(),"Mensuel", "Actif");
                break;
            case "3":
                a = new Abonnement(2,adherent.getId(),"Annuel", "Actif");
                break;
        }

        adherent.setAbonnement(a);

        System.out.println("Abonnement choisi: " + a.getType());
    }

    // ================= PROGRAMME =================

    private void voirProgramme() {
        Programme p = adherent.getProgramme();

        if (p == null) {
            System.out.println("Aucun programme.");
            return;
        }

        System.out.println("Objectif: " + p.getObjectif());

        List<Exercice> exs = p.getExercices();

        for (int i = 0; i < exs.size(); i++) {
            Exercice e = exs.get(i);
            System.out.println(i + " - " + e.getNom() + " | " + e.getSeries() + "x" + e.getRepetitions());
        }

        System.out.print("Marquer exercice terminé (index ou -1): ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < exs.size()) {
            exs.get(index).setTermine(true);
            System.out.println("Exercice terminé !");
        }
    }


}