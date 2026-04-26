import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Authentification {
    private static final int MAX_ATTEMPTS = 3;
    private static final long BLOCK_TIME_MS = 5 * 60 * 1000; // 5 minutes
    private static final Map<String, Long> blocages = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static Utilisateur login(ArrayList<Utilisateur> utilisateurs) {
        int tentatives = 0;
        String email;

        while (tentatives < MAX_ATTEMPTS) {
            System.out.print("Email : ");
            email = scanner.nextLine().trim();

            if (estBloque(email)) {
                long reste = blocages.get(email) - System.currentTimeMillis();
                System.out.println("Compte bloqué. Réessayez dans " + (reste / 1000) + " secondes.");
                continue;
            }

            System.out.print("Mot de passe : ");
            String motDePasse = scanner.nextLine().trim();

            Utilisateur utilisateur = trouverUtilisateur(utilisateurs, email);
            if (utilisateur != null && utilisateur.passwordMatches(motDePasse)) {
                utilisateur.seConnecter();
                blocages.remove(email);
                return utilisateur;
            }

            tentatives++;
            System.out.println("Email ou mot de passe incorrect. Tentative " + tentatives + " sur " + MAX_ATTEMPTS + ".");

            if (tentatives >= MAX_ATTEMPTS) {
                blocages.put(email, System.currentTimeMillis() + BLOCK_TIME_MS);
                System.out.println("Trop d'échecs. Compte bloqué pendant 5 minutes.");
            }
        }

        return null;
    }

    private static boolean estBloque(String email) {
        Long finBlocage = blocages.get(email);
        if (finBlocage == null) {
            return false;
        }
        if (System.currentTimeMillis() > finBlocage) {
            blocages.remove(email);
            return false;
        }
        return true;
    }

    private static Utilisateur trouverUtilisateur(ArrayList<Utilisateur> utilisateurs, String email) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getEmail().equalsIgnoreCase(email)) {
                return utilisateur;
            }
        }
        return null;
    }
}