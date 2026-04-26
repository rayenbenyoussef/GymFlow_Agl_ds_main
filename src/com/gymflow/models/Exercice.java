class Exercice {
    private String nom;
    private int duree; // en secondes ou minutes
    private int repetitions;
    private int series;

    private boolean istermine;

    public Exercice(String nom,int series,int repetitions) {
        this.nom = nom;
        this.repetitions = repetitions;
        this.istermine = false;
        this.series = series;
    }

    public void afficherExercice() {
        System.out.println("   - Exercice: " + nom + " | " + repetitions + " reps | Durée: " + duree + "s");
    }
    public String getNom() {
        return nom;
    }
    public int getDuree() {
        return duree;
    }
    public int getRepetitions() {
        return repetitions;
    }
    public boolean isTermines() {
        return this.istermine;
    }
    public void setTermine(boolean termines) {
        this.istermine = termines;
    }
    public int getSeries() {
        return series;
    }

}