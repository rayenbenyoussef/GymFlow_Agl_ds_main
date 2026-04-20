class Seance {
    private String type;
    private String heure;
    private int capacite;

    public Seance(String type, String heure, int capacite) {
        this.type = type;
        this.heure = heure;
        this.capacite = capacite;
    }

    public void ajouterParticipant() {
        System.out.println("[Séance] Place réservée pour " + type + " à " + heure);
    }
}