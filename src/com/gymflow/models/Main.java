import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Abonnement> abonnements = new ArrayList<>();

        int choix;

        do {
            System.out.println("\n=== MENU GYMFLOW ===");
            System.out.println("1. Ajouter un abonnement");
            System.out.println("2. Afficher tous les abonnements");
            System.out.println("3. Quitter");
            System.out.print("Votre choix: ");

            choix = scanner.nextInt();
            scanner.nextLine(); // vider buffer

            switch (choix) {

                case 1:
                    // 🔹 Saisie utilisateur
                    System.out.print("Nom du membre: ");
                    String nom = scanner.nextLine();

                    System.out.print("Type d'abonnement: ");
                    String type = scanner.nextLine();

                    System.out.print("Prix: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Date début: ");
                    String dateDebut = scanner.nextLine();

                    System.out.print("Date fin: ");
                    String dateFin = scanner.nextLine();

                    System.out.print("Statut: ");
                    String statut = scanner.nextLine();

                    // 🔹 Création + ajout dans la liste
                    Abonnement a = new Abonnement(
                            nom, type, prix, dateDebut, dateFin, statut
                    );

                    abonnements.add(a);

                    System.out.println("✅ Abonnement ajouté !");
                    break;

                case 2:
                    // 🔹 Affichage liste
                    if (abonnements.isEmpty()) {
                        System.out.println("❌ Aucun abonnement.");
                    } else {
                        System.out.println("\n📋 Liste des abonnements:");
                        for (Abonnement ab : abonnements) {
                            ab.afficherDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("👋 Au revoir !");
                    break;

                default:
                    System.out.println("❌ Choix invalide.");
            }

        } while (choix != 3);

        scanner.close();
    }
}