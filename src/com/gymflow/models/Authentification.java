import java.util.ArrayList;

public class Authentification {
    private static ArrayList<Adherent> adherents = new ArrayList<>();
    private static int prochainId = 1;

    public static Adherent inscrire(String nom, String email, String motDePasse) {
        // Vérifier que le nom n'est pas vide
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide.");
            return null;
        }

        // Vérifier que l'email n'est pas vide et contient "@"
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Erreur : L'email ne peut pas être vide.");
            return null;
        }
        if (!email.contains("@")) {
            System.out.println("Erreur : L'email doit contenir le caractère '@'.");
            return null;
        }

        // Vérifier que le mot de passe contient au moins 6 caractères
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("Erreur : Le mot de passe doit contenir au moins 6 caractères.");
            return null;
        }

        // Vérifier si l'email est déjà utilisé
        for (Adherent a : adherents) {
            if (a.getEmail().equals(email)) {
                System.out.println("Erreur : Un compte avec cet email existe déjà.");
                return null;
            }
        }

        // Créer l'adhérent et l'ajouter à la liste
        Adherent nouvelAdherent = new Adherent(prochainId++, nom, email, motDePasse);
        adherents.add(nouvelAdherent);
        System.out.println("Inscription réussie pour " + nom + ".");
        return nouvelAdherent;
    }

    public static Adherent seConnecter(String email, String motDePasse) {
        for (Adherent a : adherents) {
            if (a.getEmail().equals(email) && a.getMotDePasse().equals(motDePasse)) {
                System.out.println("Connexion réussie pour " + a.getNom() + ".");
                return a;
            }
        }
        System.out.println("Email ou mot de passe incorrect.");
        return null;
    }

    // Méthode pour obtenir la liste des adhérents (pour tests)
    public static ArrayList<Adherent> getAdherents() {
        return adherents;
    }
}
    private static ArrayList<Membre> membres = new ArrayList<>();

    public static Membre inscrire(String nom, String email, String motDePasse) {
        // Vérifier que l'email n'est pas vide et contient "@"
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Erreur : L'email ne peut pas être vide.");
            return null;
        }
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
        for (Membre m : membres) {
            if (m.getEmail().equals(email)) {
                System.out.println("Erreur : Un compte avec cet email existe déjà.");
                return null;
            }
        }

        // Créer le membre et l'ajouter à la liste
        Membre nouveauMembre = new Membre(nom, email, motDePasse);
        membres.add(nouveauMembre);
        System.out.println("Inscription réussie pour " + nom + ".");
        return nouveauMembre;
    }

    public static Membre connecter(String email, String motDePasse) {
        for (Membre m : membres) {
            if (m.getEmail().equals(email) && m.getMotDePasse().equals(motDePasse)) {
                System.out.println("Connexion réussie pour " + m.getNom() + ".");
                return m;
            }
        }
        System.out.println("Erreur : Email ou mot de passe incorrect.");
        return null;
    }

    // Méthode pour obtenir la liste des membres (pour tests ou administration)
    public static ArrayList<Membre> getMembres() {
        return membres;
    }
}

 