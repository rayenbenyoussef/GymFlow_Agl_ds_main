import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("========================================");
            System.out.println("   BIENVENUE DANS GYMFLOW - MODE INTERACTIF");
            System.out.println("========================================\n");

            // ===== INITIALISATION =====
            GestionnaireReservation gestionnaire = new GestionnaireReservation();
            ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Inscrire un nouvel adhérent");
                System.out.println("2. Ajouter une séance");
                System.out.println("3. Voir les séances disponibles");
                System.out.println("4. Se connecter");
                System.out.println("5. Quitter");
                System.out.print("Choix : ");

                String choix = scanner.nextLine().trim();
                if (choix.equals("1")) {
                    Adherent nouvelAdherent = Inscription.inscrireAdherentInteractif(scanner);
                    if (nouvelAdherent != null) {
                        utilisateurs.add(nouvelAdherent);
                        Inscription.afficherInscription(nouvelAdherent);
                    }
                } else if (choix.equals("2")) {
                    ajouterSeanceInteractif(gestionnaire, scanner);
                } else if (choix.equals("3")) {
                    gestionnaire.afficherToutesSeances();
                } else if (choix.equals("4")) {
                    if (utilisateurs.isEmpty()) {
                        System.out.println("Aucun utilisateur inscrit. Veuillez d'abord vous inscrire.");
                        continue;
                    }
                    Utilisateur utilisateurConnecte = Authentification.login(utilisateurs);
                    if (utilisateurConnecte != null) {
                        System.out.println("\nBienvenue " + utilisateurConnecte.getNom() + " !");
                    } else {
                        System.out.println("\nÉchec de la connexion.");
                    }
                } else if (choix.equals("5")) {
                    System.out.println("Au revoir !");
                    break;
                } else {
                    System.out.println("Choix invalide. Veuillez saisir 1, 2, 3, 4 ou 5.");
                }
            }
        }
    }

    private static void ajouterSeanceInteractif(GestionnaireReservation gestionnaire, Scanner scanner) {
        System.out.println("\n--- Ajout d'une nouvelle séance ---");

        System.out.print("ID de la séance : ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Type (Yoga/Cardio/Musculation) : ");
        String type = scanner.nextLine().trim();

        System.out.print("Date et heure (dd/MM/yyyy HH:mm) : ");
        String dateHeureTexte = scanner.nextLine().trim();
        LocalDateTime dateHeure;
        try {
            dateHeure = LocalDateTime.parse(dateHeureTexte, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Erreur : format de date invalide. Utilisez dd/MM/yyyy HH:mm.");
            return;
        }

        System.out.print("Capacité : ");
        int capacite = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Prix en DT : ");
        double prixDT = Double.parseDouble(scanner.nextLine().trim());

        gestionnaire.ajouterSeance(id, type, dateHeure, capacite, prixDT);
    }
}
