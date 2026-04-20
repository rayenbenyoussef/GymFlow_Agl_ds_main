class Exercice {
    private int id;
    private int idProgramme;
    private String nom;
    private int duree; // en secondes ou minutes
    private int repetitions;

    public Exercice(int id, String nom, int duree, int repetitions) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.repetitions = repetitions;
    }

    public void afficherExercice() {
        System.out.println("   - Exercice: " + nom + " | " + repetitions + " reps | Durée: " + duree + "s");
    }
}