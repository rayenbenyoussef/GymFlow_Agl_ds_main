import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private Scanner scanner = new Scanner(System.in);
    private Admin admin;

    // Same idea as CoachMenu (temporary storage)
    private List<Adherent> adherents = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public AdminMenu(Admin admin) {
        this.admin = admin;
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Gérer les utilisateurs");
            System.out.println("2. Voir les statistiques");
            System.out.println("3. Consulter les revenus");
            System.out.println("4. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    gererUtilisateurs();
                    break;
                case "2":
                    afficherStatistiques();
                    break;
                case "3":
                    menuRevenus();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // ================= USERS =================

    private void gererUtilisateurs() {
        System.out.println("\n1. Gérer les adhérents");
        System.out.println("2. Gérer les coachs");
        System.out.println("3. Rechercher par rôle");
        System.out.println("4. Retour");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                gererAdherents();
                break;
            case "2":
                gererCoachs();
                break;
            case "3":
                rechercherParRole();
                break;
        }
    }

    // ---------- ADHERENTS ----------
    private void gererAdherents() {
        System.out.println("\n1. Ajouter");
        System.out.println("2. Supprimer");
        System.out.println("3. Afficher");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                ajouterAdherent();
                break;

            case "2":
                supprimerAdherent();
                break;

            case "3":
                afficherAdherents();
                break;
        }
    }

    private void ajouterAdherent() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Téléphone: ");
        int tel = Integer.parseInt(scanner.nextLine());

        adherents.add(new Adherent(id, nom, email, tel, null, null));
        System.out.println("Adhérent ajouté !");
    }

    private void supprimerAdherent() {
        afficherAdherents();
        System.out.print("Index à supprimer: ");

        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < adherents.size()) {
            adherents.remove(index);
            System.out.println("Supprimé !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private void afficherAdherents() {
        if (adherents.isEmpty()) {
            System.out.println("Aucun adhérent.");
            return;
        }

        for (int i = 0; i < adherents.size(); i++) {
            Adherent a = adherents.get(i);
            System.out.println(i + " - " + a.getNom());
        }
    }

    // ---------- COACHS ----------
    private void gererCoachs() {
        System.out.println("\n1. Ajouter");
        System.out.println("2. Supprimer");
        System.out.println("3. Afficher");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("id: ");
                int id = scanner.nextInt();
                System.out.print("Nom: ");
                String nom = scanner.nextLine();
                System.out.print("Num telephone: ");
                int numTelephone = scanner.nextInt();
                System.out.print("email: ");
                String email = scanner.nextLine();


                coaches.add(new Coach(id, nom, email, numTelephone));
                System.out.println("Coach ajouté !");
                break;

            case "2":
                afficherCoachs();
                System.out.print("Index à supprimer: ");
                int index = Integer.parseInt(scanner.nextLine());

                if (index >= 0 && index < coaches.size()) {
                    coaches.remove(index);
                    System.out.println("Supprimé !");
                } else {
                    System.out.println("Index invalide.");
                }
                break;

            case "3":
                afficherCoachs();
                break;
        }
    }

    private void afficherCoachs() {
        if (coaches.isEmpty()) {
            System.out.println("Aucun coach.");
            return;
        }

        for (int i = 0; i < coaches.size(); i++) {
            System.out.println(i + " - " + coaches.get(i).getNom());
        }
    }

    // ---------- SEARCH ----------
    private void rechercherParRole() {
        System.out.println("\n1. Adhérents");
        System.out.println("2. Coachs");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            afficherAdherents();
        } else if (choice.equals("2")) {
            afficherCoachs();
        } else {
            System.out.println("Choix invalide.");
        }
    }

    // ================= STATS =================

    private void afficherStatistiques() {
        System.out.println("\n===== STATISTIQUES =====");

        System.out.println("Nombre d’adhérents: " + adherents.size());
        System.out.println("Nombre de réservations: " + reservations.size());

        double revenus = reservations.size() * 20; // fake logic
        System.out.println("Revenus estimés: " + revenus + " DT");

        System.out.println("Taux d’occupation: 75%"); // placeholder
    }

    // ================= REVENUS =================

    private void menuRevenus() {
        System.out.println("\n===== REVENUS =====");
        System.out.println("1. Vue journalière");
        System.out.println("2. Vue mensuelle");
        System.out.println("3. Filtrer par période");
        System.out.println("4. Exporter (PDF/Excel)");
        System.out.println("5. Retour");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Revenus du jour: 150 DT");
                break;
            case "2":
                System.out.println("Revenus du mois: 3000 DT");
                break;
            case "3":
                System.out.println("Filtrage personnalisé (à faire)");
                break;
            case "4":
                System.out.println("Export en cours...");
                break;
        }
    }

    // 👉 Dummy data (same style as CoachMenu)
    public void addDummyData() {
        adherents.add(new Adherent(1, "Alice", "alice@mail.com", 12345678, null, null));
        adherents.add(new Adherent(2, "Bob", "bob@mail.com", 87654321, null, null));

        coaches.add(new Coach(1, "Coach A", "sdffsd@vbncv", 12345678));
    }
}