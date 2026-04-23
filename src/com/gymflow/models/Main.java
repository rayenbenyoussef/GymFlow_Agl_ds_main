
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Créer une liste d'utilisateurs pour les tests
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        
        // Ajouter quelques utilisateurs de test
        utilisateurs.add(new Adherent(1, "Alice Dupont", "alice@example.com", "password123"));
        utilisateurs.add(new Adherent(2, "Bob Martin", "bob@example.com", "pass123456"));
        utilisateurs.add(new Coach(3, "Charlie Coach", "charlie@example.com", "coach1234"));
        utilisateurs.add(new Admin(4, "Admin User", "admin@example.com", "admin1234"));

        System.out.println("=== GymFlow - Système d'Authentification ===\n");
        
        // Tester la connexion
        Utilisateur utilisateur = Authentification.login(utilisateurs);
        
        if (utilisateur != null) {
            System.out.println("\nUtilisateur connecté avec succès!");
        } else {
            System.out.println("\nÉchec de la connexion.");
        }
    }
}
