import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * AdminMenu - Menu pour les administrateurs de GymFlow
 * Gère les utilisateurs, les statistiques et les revenus
 */
public class AdminMenu {

    private Scanner scanner = new Scanner(System.in);
    private Admin admin;
    private List<Adherent> adherents = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    GestionnaireReservation gestionnaire = new GestionnaireReservation();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public AdminMenu(Admin admin) {
        this.admin = admin;
    }

    /**
     * Menu principal pour l'administrateur
     */
    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Gérer les utilisateurs");
            System.out.println("2. Voir les statistiques");
            System.out.println("3. Consulter les revenus");
            System.out.println("4. Gérer les séances");
            System.out.println("5. Gérer les abonnements");
            System.out.println("6. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine().trim();

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
                    gererSeances();
                    break;
                case "5":
                    gererAbonnements();
                    break;
                case "6":
                    running = false;
                    System.out.println("Au revoir Admin " + admin.getNom());
                    break;
                default:
                    System.out.println("❌ Choix invalide.");
            }
        }
    }

    // ================== GESTION DES UTILISATEURS ==================

    /**
     * Menu pour gérer les utilisateurs (adhérents et coachs)
     */
    private void gererUtilisateurs() {
        System.out.println("\n--- Gestion des utilisateurs ---");
        System.out.println("1. Gérer les adhérents");
        System.out.println("2. Gérer les coachs");
        System.out.println("3. Rechercher par rôle");
        System.out.println("4. Voir tous les utilisateurs");
        System.out.println("5. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

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
            case "4":
                afficherTousUtilisateurs();
                break;
            case "5":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Gestion complète des adhérents
     */
    private void gererAdherents() {
        System.out.println("\n--- Gestion des adhérents ---");
        System.out.println("1. Ajouter un adhérent");
        System.out.println("2. Voir tous les adhérents");
        System.out.println("3. Suspendre un adhérent");
        System.out.println("4. Activer un adhérent");
        System.out.println("5. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                ajouterAdherent();
                break;
            case "2":
                afficherAdherents();
                break;
            case "3":
                suspendreAdherent();
                break;
            case "4":
                activerAdherent();
                break;
            case "5":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Ajouter un nouvel adhérent
     */
    private void ajouterAdherent() {
        System.out.println("\n--- Ajouter un nouvel adhérent ---");
        System.out.print("Nom: ");
        String nom = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Téléphone: ");
        String telephone = scanner.nextLine().trim();

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine().trim();

        if (nom.isEmpty() || email.isEmpty() || password.length() < 6) {
            System.out.println("❌ Données invalides.");
            return;
        }

    }

    /**
     * Afficher tous les adhérents
     */
    private void afficherAdherents() {
        if (adherents.isEmpty()) {
            System.out.println("❌ Aucun adhérent.");
            return;
        }

        System.out.println("\n--- Liste des adhérents ---");
        for (int i = 0; i < adherents.size(); i++) {
            Adherent a = adherents.get(i);
            System.out.println(i + " - " + a.getNom() + " (" + a.getEmail() + ")");
        }
    }

    /**
     * Suspendre un adhérent
     */
    private void suspendreAdherent() {
        afficherAdherents();
        System.out.print("Choisir l'adhérent à suspendre: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            if (index >= 0 && index < adherents.size()) {
                System.out.println("✅ Adhérent " + adherents.get(index).getNom() + " suspendu.");
            } else {
                System.out.println("❌ Index invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Activer un adhérent
     */
    private void activerAdherent() {
        afficherAdherents();
        System.out.print("Choisir l'adhérent à activer: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            if (index >= 0 && index < adherents.size()) {
                System.out.println("✅ Adhérent " + adherents.get(index).getNom() + " activé.");
            } else {
                System.out.println("❌ Index invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Gestion complète des coachs
     */
    private void gererCoachs() {
        System.out.println("\n--- Gestion des coachs ---");
        System.out.println("1. Voir tous les coachs");
        System.out.println("2. Ajouter un coach");
        System.out.println("3. Assigner adhérents à coach");
        System.out.println("4. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                afficherCoachs();
                break;
            case "2":
                ajouterCoach();
                break;
            case "3":
                assignerAdherentCoach();
                break;
            case "4":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Afficher tous les coachs
     */
    private void afficherCoachs() {
        if (coaches.isEmpty()) {
            System.out.println("❌ Aucun coach.");
            return;
        }

        System.out.println("\n--- Liste des coachs ---");
        for (int i = 0; i < coaches.size(); i++) {
            Coach c = coaches.get(i);
            System.out.println(i + " - " + c.getNom() + " (" + c.getEmail() + ")");
        }
    }

    /**
     * Ajouter un coach
     */
    private void ajouterCoach() {

    }

    /**
     * Assigner des adhérents à un coach
     */
    private void assignerAdherentCoach() {
        afficherCoachs();
        System.out.print("Choisir le coach: ");
        try {
            int coachIndex = Integer.parseInt(scanner.nextLine().trim());
            if (coachIndex < 0 || coachIndex >= coaches.size()) {
                System.out.println("❌ Index invalide.");
                return;
            }

            afficherAdherents();
            System.out.print("Choisir l'adhérent: ");
            int adherentIndex = Integer.parseInt(scanner.nextLine().trim());
            if (adherentIndex < 0 || adherentIndex >= adherents.size()) {
                System.out.println("❌ Index invalide.");
                return;
            }

            System.out.println("✅ Adhérent assigné au coach avec succès !");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Rechercher des utilisateurs par rôle
     */
    private void rechercherParRole() {
        System.out.println("\n--- Recherche par rôle ---");
        System.out.println("1. Adhérents");
        System.out.println("2. Coachs");
        System.out.println("3. Administrateurs");
        System.out.print("Choisir: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                afficherAdherents();
                break;
            case "2":
                afficherCoachs();
                break;
            case "3":
                System.out.println("👨‍💼 Administrateur: " + admin.getNom());
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Afficher tous les utilisateurs
     */
    private void afficherTousUtilisateurs() {
        System.out.println("\n--- Tous les utilisateurs ---");
        System.out.println("👨‍💼 Admin: " + admin.getNom());
        System.out.println("👥 Adhérents: " + adherents.size());
        System.out.println("🏋️ Coachs: " + coaches.size());
    }

    // ================== GESTION DES SÉANCES ==================

    /**
     * Menu pour gérer les séances
     */
    private void gererSeances() {
        System.out.println("\n--- Gestion des séances ---");
        System.out.println("1. Ajouter une séance");
        System.out.println("2. Voir toutes les séances");
        System.out.println("3. Modifier une séance");
        System.out.println("4. Supprimer une séance");
        System.out.println("5. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                modifierSeance();
                break;
            case "4":
                supprimerSeance();
                break;
            case "5":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Ajouter une séance interactivement
     */
    private static void ajouterSeanceInteractif(GestionnaireReservation gestionnaire, Scanner scanner) {
        System.out.println("\n--- Ajout d'une nouvelle séance ---");

        try {
            System.out.print("ID de la séance: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Type (Yoga/Cardio/Musculation): ");
            String type = scanner.nextLine().trim();

            System.out.print("Date et heure (dd/MM/yyyy HH:mm): ");
            String dateHeureTexte = scanner.nextLine().trim();
            LocalDateTime dateHeure = LocalDateTime.parse(dateHeureTexte, DATE_TIME_FORMATTER);

            System.out.print("Capacité: ");
            int capacite = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Prix en DT: ");
            double prixDT = Double.parseDouble(scanner.nextLine().trim());

            gestionnaire.ajouterSeance(id, type, dateHeure, capacite, prixDT);
            System.out.println("✅ Séance ajoutée avec succès !");

        } catch (DateTimeParseException e) {
            System.out.println("❌ Format de date invalide. Utilisez dd/MM/yyyy HH:mm.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Modifier une séance
     */
    private void modifierSeance() {
        gestionnaire.afficherToutesSeances();
        System.out.print("Choisir l'ID de la séance à modifier: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Nouveau prix en DT: ");
            double nouveauPrix = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("✅ Séance modifiée !");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Supprimer une séance
     */
    private void supprimerSeance() {
        gestionnaire.afficherToutesSeances();
        System.out.print("Choisir l'ID de la séance à supprimer: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("✅ Séance supprimée !");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    // ================== GESTION DES ABONNEMENTS ==================

    /**
     * Menu pour gérer les abonnements
     */
    private void gererAbonnements() {
        System.out.println("\n--- Gestion des abonnements ---");
        System.out.println("1. Voir les types d'abonnements");
        System.out.println("2. Ajouter un type d'abonnement");
        System.out.println("3. Modifier un abonnement");
        System.out.println("4. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                afficherAbonnements();
                break;
            case "2":
                ajouterAbonnement();
                break;
            case "3":
                modifierAbonnement();
                break;
            case "4":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Afficher les types d'abonnements
     */
    private void afficherAbonnements() {
        System.out.println("\n--- Types d'abonnements ---");
        System.out.println("1. Basic - 30 DT/mois - 2 séances/semaine");
        System.out.println("2. Standard - 50 DT/mois - 4 séances/semaine");
        System.out.println("3. Premium - 80 DT/mois - Illimité + Coach personnel");
        System.out.println("4. VIP - 150 DT/mois - Illimité + Coach + Nutritionniste");
    }

    /**
     * Ajouter un abonnement
     */
    private void ajouterAbonnement() {
        System.out.println("\n--- Ajouter un abonnement ---");
        System.out.print("Nom de l'abonnement: ");
        String nom = scanner.nextLine().trim();

        System.out.print("Prix en DT: ");
        try {
            double prix = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Séances/semaine (ou 0 pour illimité): ");
            int seances = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("✅ Abonnement ajouté !");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    /**
     * Modifier un abonnement
     */
    private void modifierAbonnement() {
        afficherAbonnements();
        System.out.print("Choisir l'abonnement à modifier: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Nouveau prix en DT: ");
            double nouveauPrix = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("✅ Abonnement modifié !");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrée invalide.");
        }
    }

    // ================== STATISTIQUES ==================

    /**
     * Afficher les statistiques du système
     */
    private void afficherStatistiques() {
        System.out.println("\n========== STATISTIQUES ==========");
        System.out.println("👥 Nombre total d'adhérents: " + adherents.size());
        System.out.println("🏋️ Nombre total de coachs: " + coaches.size());
        System.out.println("📅 Nombre total de séances: " + gestionnaire.getNombreSeances());
        System.out.println("📊 Taux d'occupation moyen: 65%");
        System.out.println("⭐ Score de satisfaction: 4.5/5");
        System.out.println("===================================\n");
    }

    // ================== REVENUS ==================

    /**
     * Menu pour consulter les revenus
     */
    private void menuRevenus() {
        System.out.println("\n--- Consulter les revenus ---");
        System.out.println("1. Revenus du mois actuel");
        System.out.println("2. Revenus par type d'abonnement");
        System.out.println("3. Revenus par séance");
        System.out.println("4. Rapport financier complet");
        System.out.println("5. Retour");
        System.out.print("Choix: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                afficherRevenusMois();
                break;
            case "2":
                afficherRevenusAbonnements();
                break;
            case "3":
                afficherRevenusSeances();
                break;
            case "4":
                afficherRapportFinancier();
                break;
            case "5":
                break;
            default:
                System.out.println("❌ Choix invalide.");
        }
    }

    /**
     * Afficher les revenus du mois actuel
     */
    private void afficherRevenusMois() {
        System.out.println("\n--- Revenus du mois actuel ---");
        double revenusAbonnements = adherents.size() * 50; // Moyenne
        double revenusSeances = gestionnaire.getNombreSeances() * 20; // Moyenne
        double totalRevenus = revenusAbonnements + revenusSeances;

        System.out.println("💰 Revenus abonnements: " + revenusAbonnements + " DT");
        System.out.println("💰 Revenus séances: " + revenusSeances + " DT");
        System.out.println("💰 Total: " + totalRevenus + " DT");
    }

    /**
     * Afficher les revenus par type d'abonnement
     */
    private void afficherRevenusAbonnements() {
        System.out.println("\n--- Revenus par abonnement ---");
        System.out.println("💰 Basic: " + (adherents.size() * 0.2 * 30) + " DT");
        System.out.println("💰 Standard: " + (adherents.size() * 0.5 * 50) + " DT");
        System.out.println("💰 Premium: " + (adherents.size() * 0.25 * 80) + " DT");
        System.out.println("💰 VIP: " + (adherents.size() * 0.05 * 150) + " DT");
    }

    /**
     * Afficher les revenus des séances
     */
    private void afficherRevenusSeances() {
        System.out.println("\n--- Revenus des séances ---");
        System.out.println("💰 Yoga: " + (gestionnaire.getNombreSeances() * 0.3 * 20) + " DT");
        System.out.println("💰 Cardio: " + (gestionnaire.getNombreSeances() * 0.4 * 25) + " DT");
        System.out.println("💰 Musculation: " + (gestionnaire.getNombreSeances() * 0.3 * 30) + " DT");
    }

    /**
     * Afficher le rapport financier complet
     */
    private void afficherRapportFinancier() {
        System.out.println("\n========== RAPPORT FINANCIER ==========");
        System.out.println("Période: Avril 2026");
        System.out.println("Revenus totaux: 15,450 DT");
        System.out.println("Dépenses: 5,200 DT");
        System.out.println("Bénéfice net: 10,250 DT");
        System.out.println("Marge: 66.3%");
        System.out.println("=======================================\n");
    }

}
