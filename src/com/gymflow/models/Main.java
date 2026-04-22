
public class Main {
    public static void main(String[] args) {
        // Test d'inscription valide
        System.out.println("=== Test d'inscription valide ===");
        Adherent adherent1 = Authentification.inscrire("Alice Dupont", "alice@example.com", "password123");
        if (adherent1 != null) {
            adherent1.afficherDetails();
        }
        System.out.println();

        // Test d'inscription avec email invalide
        System.out.println("=== Test d'inscription avec email invalide ===");
        Adherent adherent2 = Authentification.inscrire("Bob Martin", "bobexample.com", "pass123");
        System.out.println();

        // Test d'inscription avec mot de passe trop court
        System.out.println("=== Test d'inscription avec mot de passe trop court ===");
        Adherent adherent3 = Authentification.inscrire("Charlie Brown", "charlie@example.com", "123");
        System.out.println();

        // Test d'inscription avec email déjà utilisé
        System.out.println("=== Test d'inscription avec email déjà utilisé ===");
        Adherent adherent4 = Authentification.inscrire("Alice Clone", "alice@example.com", "differentpass");
        System.out.println();

        // Test de connexion valide
        System.out.println("=== Test de connexion valide ===");
        Adherent connecte = Authentification.seConnecter("alice@example.com", "password123");
        System.out.println();

        // Test de connexion avec mauvais mot de passe
        System.out.println("=== Test de connexion avec mauvais mot de passe ===");
        Adherent connecte2 = Authentification.seConnecter("alice@example.com", "wrongpass");
        System.out.println();

        // Test de connexion avec email inexistant
        System.out.println("=== Test de connexion avec email inexistant ===");
        Adherent connecte3 = Authentification.seConnecter("nonexistent@example.com", "password123");
        System.out.println();

        // Affichage du nombre total d'adhérents inscrits
        System.out.println("Nombre total d'adhérents inscrits : " + Authentification.getAdherents().size());
    }
}
