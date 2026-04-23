import java.util.ArrayList;
import java.util.Scanner;

class Inscription {
    private static int prochainId = 1;
    private static ArrayList<Adherent> adherents = new ArrayList<>();

    // Méthode pour inscrire un nouvel adhérent
    public static Adherent inscrireAdherent(String nom, String email, String motDePasse) {
        // Vérifier que le nom n'est pas vide
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email n'est pas vide
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Erreur : L'email ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email contient "@"
        if (!email.contains("@")) {
            System.out.println("Erreur : L'email doit contenir le caractère '@'.");
            return null;
        }

        // Vérifier que le mot de passe a au moins 6 caractères
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("Erreur : Le mot de passe doit contenir au moins 6 caractères.");
            return null;
        }

        // Vérifier si l'email est déjà utilisé
        if (emailDejaPris(email)) {
            System.out.println("Erreur : Un compte avec cet email existe déjà.");
            return null;
        }

        // Créer un nouvel adhérent
        Adherent nouvelAdherent = new Adherent(prochainId++, nom.trim(), email.trim(), motDePasse);
        adherents.add(nouvelAdherent);

        System.out.println("✓ Inscription réussie pour " + nom.trim() + ".");
        return nouvelAdherent;
    }

    // Méthode pour afficher les informations d'un adhérent
    public static void afficherInscription(Adherent adherent) {
        if (adherent == null) {
            System.out.println("Adhérent non disponible.");
            return;
        }

        System.out.println("\n--- Informations d'inscription ---");
        System.out.println("ID: " + adherent.getId());
        System.out.println("Nom: " + adherent.getNom());
        System.out.println("Email: " + adherent.getEmail());
        System.out.println("----------------------------------");
    }

    // Vérifier si un email est déjà pris
    private static boolean emailDejaPris(String email) {
        for (Adherent a : adherents) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    // Obtenir la liste des adhérents
    public static ArrayList<Adherent> getAdherents() {
        return adherents;
    }

    // Méthode interactive pour l'inscription via Scanner
    public static Adherent inscrireAdherentInteractif(Scanner scanner) {
        System.out.println("\n=== Formulaire d'inscription ===");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        return inscrireAdherent(nom, email, motDePasse);
    }
}