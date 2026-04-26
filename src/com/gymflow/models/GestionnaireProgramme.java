import java.util.ArrayList;

public class GestionnaireProgramme {

    private ArrayList<Programme> programmes;

    public GestionnaireProgramme() {
        programmes = new ArrayList<>();
    }

    // ===== GESTION DES PROGRAMMES =====

    public boolean ajouterProgramme(String objectif, int idAdherent) {

        // 🔒 éviter doublon
        if (trouverProgramme(idAdherent) != null) {
            System.out.println("⚠ Cet adhérent a déjà un programme !");
            return false;
        }

        Programme p = new Programme(objectif, idAdherent);
        programmes.add(p);

        System.out.println("✓ Programme ajouté pour adhérent ID: " + idAdherent);
        return true;
    }

    public Programme trouverProgramme(int idAdherent) {
        for (Programme p : programmes) {
            if (p.getIdAdherent() == idAdherent) {
                return p;
            }
        }
        return null;
    }

    public void afficherProgramme(int idAdherent) {
        Programme p = trouverProgramme(idAdherent);

        if (p == null) {
            System.out.println("Aucun programme trouvé.");
            return;
        }

        System.out.println("\n=== PROGRAMME ADHERENT " + idAdherent + " ===");
        System.out.println("Objectif: " + p.getObjectif());

        if (p.getExercices().isEmpty()) {
            System.out.println("Aucun exercice.");
        } else {
            for (int i = 0; i < p.getExercices().size(); i++) {
                Exercice e = p.getExercices().get(i);

                String status = e.isTermines() ? "✔ Terminé" : "❌ Non terminé";

                System.out.println(i + " - " + e.getNom() + " | "
                        + e.getSeries() + "x" + e.getRepetitions()
                        + " | " + status);
            }
        }

        System.out.println("==============================\n");
    }

    // ===== GESTION DES EXERCICES =====

    public boolean ajouterExercice(int idAdherent, String nom, int series, int repetitions) {
        Programme p = trouverProgramme(idAdherent);

        if (p == null) {
            System.out.println("Erreur : Programme introuvable.");
            return false;
        }

        Exercice e = new Exercice(nom, series, repetitions);
        p.ajouterExercice(e);

        System.out.println("✓ Exercice ajouté : " + nom);
        return true;
    }

    public boolean terminerExercice(int idAdherent, int index) {
        Programme p = trouverProgramme(idAdherent);

        if (p == null) {
            System.out.println("Programme introuvable.");
            return false;
        }

        if (index < 0 || index >= p.getExercices().size()) {
            System.out.println("Index invalide.");
            return false;
        }

        p.getExercices().get(index).setTermine(true);

        System.out.println("✓ Exercice marqué comme terminé !");
        return true;
    }

    // ===== BONUS (important 🔥) =====

    public boolean supprimerProgramme(int idAdherent) {
        Programme p = trouverProgramme(idAdherent);

        if (p == null) {
            return false;
        }

        programmes.remove(p);
        return true;
    }

    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }
}