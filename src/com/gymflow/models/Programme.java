import java.util.ArrayList;
public class Programme {
    private String objectif;
    private Adherent adherent;
    private ArrayList<Exercice> exercices;

    public Programme(String objectif, Adherent adherent) {
        this.objectif = objectif;
        this.adherent = adherent;
        this.exercices = new ArrayList<>();
    }

    public void ajouterExercice(Exercice exercice) {
        System.out.println("[Programme] Nouvel exercice ajouté au plan : " + objectif);
    }

    public String getObjectif() {
        return objectif;
    }
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
    public Adherent getAdherent() {
        return adherent;
    }
    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    public ArrayList<Exercice> getExercices() {
        return exercices;
    }


    
}