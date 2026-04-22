import java.util.ArrayList;
import java.util.List;

public class Programme {
    private String nom;
    private String objectif;
    private List<Exercice> exercices;
    private String nomAdherentAssigne;

    public Programme(String nom, String objectif) {
        this.nom = nom;
        this.objectif = objectif;
        this.exercices = new ArrayList<>();
    }

    public void ajouterExercice(Exercice e) {
        if (e != null) {
            exercices.add(e);
        }
    }

    public void assignerA(String nomAdherent) {
        this.nomAdherentAssigne = nomAdherent;
    }

    public double calculerProgression() {
        if (exercices.isEmpty()) return 0;
        long nbTermines = exercices.stream().filter(Exercice::isEstTermine).count();
        return (double) nbTermines / exercices.size() * 100;
    }

    public List<Exercice> getExercices() { return exercices; }
    public String getNom() { return nom; }
    public String getObjectif() { return objectif; }
}