import java.util.ArrayList;

public class Programme {
    private String objectif;
    private int idAdherent;
    private ArrayList<Exercice> exercices;

    public Programme(String objectif, int idAdherent) {
        this.objectif = objectif;
        this.idAdherent = idAdherent;
        this.exercices = new ArrayList<>();
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public ArrayList<Exercice> getExercices() {
        return exercices;
    }

    // ✅ ajouter exercice
    public void ajouterExercice(Exercice e) {
        exercices.add(e);
    }
}