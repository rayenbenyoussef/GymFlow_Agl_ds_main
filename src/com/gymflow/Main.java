import models.AdherentMenu;
import models.AdminMenu;
import models.CoachMenu;

import java.util.Scanner;

public class Main {
    private Scanner scanner;
    public static Utilisateur tempUtilisateur;
    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static Utilisateur findUserByEmail(String email) {
        // Simulate user retrieval based on email
        return null;
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
                    handleLogin();
                    break;
                case "2":
                    handleRegister();
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

    private void handleLogin() {
        System.out.println("\n--- Se connecter ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        // TEMPORARY (no auth system yet)
        System.out.println("Connexion simulée réussie pour: " + email);
        System.out.println("Utilisateur non trouvé. Veuillez vous inscrire.");
        tempUtilisateur = findUserByEmail(email);
        if(tempUtilisateur.getRole().equals("admin")) {
            new AdminMenu();
        }else if(tempUtilisateur.getRole().equals("coach")) {
            new CoachMenu();
        }else if(tempUtilisateur.getRole().equals("adherent")) {
            new AdherentMenu();
        }else {
            System.out.println("Rôle non reconnu."); 
        }
        
        
    }

    private void handleRegister() {
        System.out.println("\n--- S'inscrire ---");
        System.out.print("Nom complet: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Num de Telephone: ");
        String nt = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        System.out.print("mote de passe: ");
        String mdp = scanner.nextLine();


        System.out.println("Utilisateur créé (simulation): " + name);
    }


    private void handleExit() {
        System.out.println("Au revoir !");
        scanner.close();
    }

    public static void main(String[] args) {
        new Main().displayMenu();
    }
}