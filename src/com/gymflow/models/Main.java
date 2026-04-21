// Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin(1, "Ahmed Ben Salem", "ahmed.admin@gymflow.tn");
        
        // Données fictives (Tunisie)
        List<Utilisateur> db = new ArrayList<>();
        db.add(new Adherent(10, "Sami Dridi", "sami@mail.tn"));
        db.add(new Adherent(11, "Leila Trabelsi", "leila@mail.tn"));
        db.add(new Coach(20, "Mourad Gharbi", "mourad.coach@gymflow.tn"));

        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("   GYMFLOW - CONSOLE ADMIN ");
            System.out.println("===============================");
            System.out.println("1. Afficher les Adhérents");
            System.out.println("2. Afficher les Coachs");
            System.out.println("3. Consulter Revenus & Exports");
            System.out.println("4. Voir Statistiques Globales");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1 -> admin.gererUtilisateurs(db, "Adherent");
                case 2 -> admin.gererUtilisateurs(db, "Coach");
                case 3 -> admin.consulterFinances();
                case 4 -> admin.afficherStatsGlobales();
                case 5 -> {
                    running = false;
                    System.out.println("Déconnexion... Beslama !");
                }
                default -> System.out.println("Option invalide.");
            }
        }
        scanner.close();
    }
}