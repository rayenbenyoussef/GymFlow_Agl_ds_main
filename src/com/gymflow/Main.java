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
                    if (utilisateurs.isEmpty()) {
                        System.out.println("Aucun utilisateur inscrit. Veuillez d'abord vous inscrire.");
                        continue;
                    }
                    Utilisateur utilisateurConnecte = Authentification.login(utilisateurs);
                    if (utilisateurConnecte != null) {
                        System.out.println("\nBienvenue " + utilisateurConnecte.getNom() + " !");
                        if(utilisateurConnecte instanceof Adherent) {
                            new AdherentMenu((Adherent) utilisateurConnecte).displayMenu();
                        } else if (utilisateurConnecte instanceof Coach) {
                            new CoachMenu((Coach) utilisateurConnecte).displayMenu();
                        } else if (utilisateurConnecte instanceof Admin) {
                            new AdminMenu((Admin) utilisateurConnecte).displayMenu();
                        }

                    } else {
                        System.out.println("\nÉchec de la connexion.");
                    }
                    break;
                case "2":
                    System.out.println("\nChossez un rôle pour l'inscription:");
                    System.out.println("1. Adhérent");
                    System.out.println("2. Coach");
                    System.out.println("3. Administrateur");
                    System.out.println("Choix: ");
                    String roleChoice = scanner.nextLine().trim();
                    switch (roleChoice) {
                        case "1":
                            Adherent nouvelAdherent = Inscription.inscrireAdherentInteractif(scanner);
                            if (nouvelAdherent != null) {
                                utilisateurs.add(nouvelAdherent);
                                Inscription.afficherInscription(nouvelAdherent);
                            }
                            break;
                        case "2":
                            Coach nouvelCoach = Inscription.inscrireCoachInteractif(scanner);
                            if (nouvelCoach != null) {
                                utilisateurs.add(nouvelCoach);
                                Inscription.afficherInscription(nouvelCoach);
                            }
                            break;
                        case "3":
                            Admin nouvelAdmin = Inscription.inscrireAdminInteractif(scanner);
                            if (nouvelAdmin != null) {
                                utilisateurs.add(nouvelAdmin);
                                Inscription.afficherInscription(nouvelAdmin);
                            }
                            break;
                        default:
                            System.out.println("Option de rôle invalide.");
                    }
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