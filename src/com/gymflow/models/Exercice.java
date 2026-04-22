public class Exercice {
    private String nom;
    private int series;
    private int repetitions;
    private int repos; // en secondes
    private boolean estTermine;

    public Exercice(String nom, int series, int repetitions, int repos) {
        this.nom = nom;
        this.series = series;
        this.repetitions = repetitions;
        this.repos = repos;
        this.estTermine = false;
    }

    public void marquerCommeTermine() {
        this.estTermine = true;
    }

    public boolean isEstTermine() { return estTermine; }
    public String getNom() { return nom; }

    @Override
    public String toString() {
        String statut = estTermine ? "[✅ Terminé]" : "[⏳ En cours]";
        return statut + " " + nom + " : " + series + "x" + repetitions + " (Repos: " + repos + "s)";
    }
}