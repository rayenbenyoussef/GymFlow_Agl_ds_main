import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdherentMenu {

    private Scanner scanner = new Scanner(System.in);

    private Adherent adherent;

    private List<Seance> seances = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Abonnement> abonnements = new ArrayList<>();

    public AdherentMenu(Adherent adherent) {
        this.adherent = adherent;
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU ADHERENT =====");
            System.out.println("1. Voir & réserver une séance");
            System.out.println("2. Annuler une réservation");
            System.out.println("3. Voir mon abonnement");
            System.out.println("4. Choisir un abonnement");
            System.out.println("5. Voir mon programme");
            System.out.println("6. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    reserverSeance();
                    break;
                case "2":
                    annulerReservation();
                    break;
                case "3":
                    voirAbonnement();
                    break;
                case "4":
                    choisirAbonnement();
                    break;
                case "5":
                    voirProgramme();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // ================= RESERVATION =================

    private void reserverSeance() {
        System.out.println("\nChoisir type:");
        System.out.println("1. Yoga");
        System.out.println("2. Cardio");
        System.out.println("3. Musculation");

        String type = scanner.nextLine();

        List<Seance> filtered = new ArrayList<>();

        for (Seance s : seances) {
            if (s.getType().equalsIgnoreCase(typeToString(type))) {
                filtered.add(s);
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("Aucune séance disponible.");
            return;
        }

        for (int i = 0; i < filtered.size(); i++) {
            Seance s = filtered.get(i);
            System.out.println(i + " - " + s.getNom() + " | " + s.getHeure() + " | places: " + s.getPlaces());
        }

        System.out.print("Choisir séance: ");
        int index = Integer.parseInt(scanner.nextLine());

        Seance s = filtered.get(index);

        if (s.getPlaces() <= 0) {
            System.out.println("Plus de places disponibles.");
            return;
        }

        s.decrementerPlaces();

        Reservation r = new Reservation(adherent, s);
        reservations.add(r);

        System.out.println("✅ Réservation confirmée: " + s.getNom() + " | " + s.getHeure() + " | " + s.getType());
    }

    // ================= CANCEL =================

    private void annulerReservation() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.println(i + " - " + r.getSeance().getNom() + " | " + r.getSeance().getType());
        }

        System.out.print("Choisir réservation: ");
        int index = Integer.parseInt(scanner.nextLine());

        Reservation r = reservations.get(index);

        if (r.getSeance().getHeure().minusHours(1).isBefore(LocalDateTime.now())) {
            System.out.println("Impossible d'annuler (moins de 1h).");
            return;
        }

        r.getSeance().incrementerPlaces();
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
        System.out.println("Expire le: " + a.getExpirationDate());
    }

    private void choisirAbonnement() {
        System.out.println("\n1. Journalier - 10 DT");
        System.out.println("2. Mensuel - 100 DT");
        System.out.println("3. Annuel - 800 DT");

        String choice = scanner.nextLine();

        Abonnement a = null;

        switch (choice) {
            case "1":
                a = new Abonnement("Journalier", "Actif");
                break;
            case "2":
                a = new Abonnement("Mensuel", "Actif");
                break;
            case "3":
                a = new Abonnement("Annuel", "Actif");
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

    // ================= UTILS =================

    private String typeToString(String choice) {
        switch (choice) {
            case "1": return "Yoga";
            case "2": return "Cardio";
            case "3": return "Musculation";
        }
        return "";
    }

    // Dummy data
    public void addDummyData() {
        seances.add(new Seance("Yoga" , LocalDateTime.now().plusHours(1), 10));
        seances.add(new Seance("Cardio",LocalDateTime.now().plusHours(3), 5));
        seances.add(new Seance("Musculation", LocalDateTime.now().plusHours(6), 8));
    }
}