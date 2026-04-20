class Programme {
    private String nom;
    private String description;

    public Programme(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public void ajouterExercice() {
        System.out.println("[Programme] Nouvel exercice ajouté au plan : " + nom);
    }
}