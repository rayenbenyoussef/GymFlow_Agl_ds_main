
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GymFlow - Test d'Inscription ===\n");

        // Test 1: Inscription valide
        System.out.println("--- Test 1: Inscription valide ---");
        Adherent adherent1 = Inscription.inscrireAdherent("Alice Dupont", "alice@example.com", "password123");
        if (adherent1 != null) {
            Inscription.afficherInscription(adherent1);
        }

        // Test 2: Inscription avec email invalide
        System.out.println("\n--- Test 2: Email sans '@' ---");
        Adherent adherent2 = Inscription.inscrireAdherent("Bob Martin", "bobexample.com", "pass123456");

        // Test 3: Inscription avec mot de passe trop court
        System.out.println("\n--- Test 3: Mot de passe trop court ---");
        Adherent adherent3 = Inscription.inscrireAdherent("Charlie Brown", "charlie@example.com", "123");

        // Test 4: Inscription avec email déjà utilisé
        System.out.println("\n--- Test 4: Email déjà utilisé ---");
        Adherent adherent4 = Inscription.inscrireAdherent("Alice Clone", "alice@example.com", "differentpass");

        // Test 5: Inscription avec nom vide
        System.out.println("\n--- Test 5: Nom vide ---");
        Adherent adherent5 = Inscription.inscrireAdherent("", "empty@example.com", "password123");

        // Affichage du nombre total d'adhérents inscrits
        System.out.println("\n--- Résumé ---");
        System.out.println("Nombre total d'adhérents inscrits : " + Inscription.getAdherents().size());

        // Test de connexion avec les adhérents inscrits
        System.out.println("\n=== GymFlow - Test d'Authentification ===\n");
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.addAll(Inscription.getAdherents());
        utilisateurs.add(new Coach(100, "Coach Test", "coach@example.com", "coach1234"));
        utilisateurs.add(new Admin(101, "Admin Test", "admin@example.com", "admin1234"));

        Utilisateur utilisateur = Authentification.login(utilisateurs);

        if (utilisateur != null) {
            System.out.println("\nUtilisateur connecté avec succès!");
        } else {
            System.out.println("\nÉchec de la connexion.");
        }
    }
}
