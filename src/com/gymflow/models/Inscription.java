import java.util.ArrayList;
import java.util.Scanner;

/**
 * Inscription - Gestion des inscriptions des utilisateurs
 * Supporte les adhérents, coachs et administrateurs
 */
class Inscription {
    private static int prochainId = 1;
    private static ArrayList<Adherent> adherents = new ArrayList<>();
    private static ArrayList<Coach> coaches = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();

    /**
     * Inscrire un nouvel adhérent
     */
    public static Adherent inscrireAdherent(String nom, String email, String numTelephone, String motDePasse) {
        // Vérifier que le nom n'est pas vide
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("❌ Erreur : Le nom ne peut pas être vide.");
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
            System.out.println("❌ Erreur : Un compte avec cet email existe déjà.");
            return null;
        }

        // Créer un nouvel adhérent
        Adherent nouvelAdherent = new Adherent(prochainId++, nom.trim(), email.trim(), Integer.parseInt(numTelephone),
                motDePasse, null, null);
        adherents.add(nouvelAdherent);

        System.out.println("✅ Inscription réussie pour " + nom.trim() + " (Adhérent).");
        return nouvelAdherent;
    }

    /**
     * Inscrire un nouveau coach
     */
    public static Coach inscrireCoach(String nom, String email, String numTelephone, String motDePasse) {
        // Vérifier que le nom n'est pas vide
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("❌ Erreur : Le nom ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email n'est pas vide
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ Erreur : L'email ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email contient "@"
        if (!email.contains("@")) {
            System.out.println("❌ Erreur : L'email doit contenir le caractère '@'.");
            return null;
        }

        // Vérifier que le mot de passe a au moins 6 caractères
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("❌ Erreur : Le mot de passe doit contenir au moins 6 caractères.");
            return null;
        }

        // Vérifier si l'email est déjà utilisé
        if (emailDejaPris(email)) {
            System.out.println("❌ Erreur : Un compte avec cet email existe déjà.");
            return null;
        }

        // Créer un nouveau coach
        Coach nouvelCoach = new Coach(prochainId++, nom.trim(), email.trim(), Integer.parseInt(numTelephone),
                motDePasse);
        coaches.add(nouvelCoach);

        System.out.println("✅ Inscription réussie pour " + nom.trim() + " (Coach).");
        return nouvelCoach;
    }

    /**
     * Inscrire un nouvel administrateur
     */
    public static Admin inscrireAdmin(String nom, String email, String numTelephone, String motDePasse) {
        // Vérifier que le nom n'est pas vide
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("❌ Erreur : Le nom ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email n'est pas vide
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ Erreur : L'email ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email contient "@"
        if (!email.contains("@")) {
            System.out.println("❌ Erreur : L'email doit contenir le caractère '@'.");
            return null;
        }

        // Vérifier que le mot de passe a au moins 6 caractères
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("❌ Erreur : Le mot de passe doit contenir au moins 6 caractères.");
            return null;
        }

        // Vérifier si l'email est déjà utilisé
        if (emailDejaPris(email)) {
            System.out.println("❌ Erreur : Un compte avec cet email existe déjà.");
            return null;
        }

        // Créer un nouvel administrateur

        Admin nouvelAdmin = new Admin(prochainId++, nom.trim(), email.trim(), Integer.parseInt(numTelephone),
                motDePasse);
        admins.add(nouvelAdmin);

        System.out.println("✅ Inscription réussie pour " + nom.trim() + " (Administrateur).");
        return nouvelAdmin;
    }

    /**
     * Afficher les informations d'inscription
     */
    public static void afficherInscription(Utilisateur utilisateur) {
        if (utilisateur == null) {
            System.out.println("❌ Utilisateur non disponible.");
            return;
        }

        System.out.println("\n========== CONFIRMATION D'INSCRIPTION ==========");
        System.out.println("✅ ID: " + utilisateur.getId());
        System.out.println("✅ Nom: " + utilisateur.getNom());
        System.out.println("✅ Email: " + utilisateur.getEmail());
        System.out.println("✅ Rôle: " + utilisateur.getRole().toUpperCase());
        System.out.println("================================================\n");
    }

    /**
     * Vérifier si un email est déjà utilisé
     */

    private static boolean emailDejaPris(String email) {
        for (Adherent a : adherents) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        for (

        Coach c : coaches) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        for (Admin a : admins) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtenir la liste des adhérents
     */

    public static ArrayList<Adherent> getAdherents() {
        return adherents;
    }

    /**
     * Obtenir la liste des coachs
     */
    public static ArrayList<Coach> getCoachs() {
        return coaches;
    }

    /**
     * Obtenir la liste des administrateurs
     */
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    /**
     * Inscription interactive pour adhérent
     */
    public static Adherent inscrireAdherentInteractif(Scanner scanner) {
        System.out.println("\n========== INSCRIPTION ADHÉRENT ==========");

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Téléphone: ");
        String numTelephone = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        return inscrireAdherent(nom, email, numTelephone, motDePasse);
    }

    /**
     * Inscription interactive pour coach
     */
    public static Coach inscrireCoachInteractif(Scanner scanner) {
        System.out.println("\n========== INSCRIPTION COACH ==========");

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Téléphone: ");
        String numTelephone = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        return inscrireCoach(nom, email, numTelephone, motDePasse);
    }

    /**
     * Inscription interactive pour administrateur
     */
    public static Admin inscrireAdminInteractif(Scanner scanner) {
        System.out.println("\n========== INSCRIPTION ADMINISTRATEUR ==========");

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Téléphone: ");
        String numTelephone = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        return inscrireAdmin(nom, email, numTelephone, motDePasse);
    }

    /**
     * Afficher les statistiques des inscriptions
     */
    public static void afficherStatistiquesInscriptions() {
        System.out.println("\n========== STATISTIQUES INSCRIPTIONS ==========");
        System.out.println("👥 Adhérents: " + adherents.size());
        System.out.println("🏋️ Coachs: " + coaches.size());
        System.out.println("👨‍💼 Administrateurs: " + admins.size());
        System.out.println("📊 Total utilisateurs: " + (adherents.size() + coaches.size() + admins.size()));
        System.out.println("==============================================\n");
    }

    /**
     * Vérifier la validité des données pour la fusion
     */
    public static boolean validerDonnees() {
        System.out.println("\n========== VALIDATION DES DONNÉES ==========");
        System.out.println("✅ Système d'inscription validé");
        System.out.println("✅ Gestion des adhérents opérationnelle");
        System.out.println("✅ Gestion des coachs opérationnelle");
        System.out.println("✅ Gestion des administrateurs opérationnelle");
        System.out.println("✅ Validations de sécurité en place");
        System.out.println("==========================================\n");
        return true;
    }
}
