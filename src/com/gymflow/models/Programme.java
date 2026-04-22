import java.util.ArrayList;
import java.util.List;

class Programme {
    private String nom;
    private String description;
    private String objectif; // ex: Prise de masse, Perte de poids
    private List<String> exercices;
    private List<String> historiquePerformances;

    public Programme(String nom, String description, String objectif) {
        this.nom = nom;
        this.description = description;
        this.objectif = objectif;
        this.exercices = new ArrayList<>();
        this.historiquePerformances = new ArrayList<>();
    }

    // Pour l'User Story 1 : Le Coach ajoute des exercices
    public void ajouterExercice(String exercice) {
        this.exercices.add(exercice);
        System.out.println("[Coach] Exercice ajouté : " + exercice);
    }

    // Pour l'User Story 2 : L'Adhérent enregistre ses perfs
    public void enregistrerPerformance(String exercice, int series, int reps, double poids) {
        String log = "Ex: " + exercice + " | " + series + "x" + reps + " @ " + poids + "kg";
        this.historiquePerformances.add(log);
        System.out.println("[Adhérent] Performance enregistrée : " + log);
    }

    public void afficherProgramme() {
        System.out.println("\n--- PROGRAMME : " + nom + " (" + objectif + ") ---");
        System.out.println("Description : " + description);
        System.out.println("Exercices prévus : " + exercices);
    }

    public void afficherEvolution() {
        System.out.println("\n--- HISTORIQUE DES PERFORMANCES ---");
        for (String perf : historiquePerformances) {
            System.out.println("- " + perf);
        }
    }
}