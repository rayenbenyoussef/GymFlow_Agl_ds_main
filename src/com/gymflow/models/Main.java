import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Création d'un abonnement ===");

        System.out.print("Nom du membre: ");
        String nom = scanner.nextLine();

        System.out.print("Type d'abonnement (Basic/Premium...): ");
        String type = scanner.nextLine();

        System.out.print("Prix: ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // vider le buffer

        System.out.print("Date début (jj/mm/aaaa): ");
        String dateDebut = scanner.nextLine();

        System.out.print("Date fin (jj/mm/aaaa): ");
        String dateFin = scanner.nextLine();

        System.out.print("Statut (Actif/Expiré/En attente): ");
        String statut = scanner.nextLine();

        // Création de l'objet
        Abonnement abonnement = new Abonnement(
                nom, type, prix, dateDebut, dateFin, statut
        );

        // Affichage
        abonnement.afficherDetails();

        scanner.close();
    }
}