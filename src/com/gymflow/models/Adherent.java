class Adherent extends Utilisateur {
    private Abonnement abonnement;
    private Programme programme;
    public Adherent(int id, String nom, String email, int numTelephone, Abonnement abonnement, Programme programme) {
        super(id, nom, email,numTelephone, "adherent");
        this.abonnement = abonnement;
        this.programme = programme;
    }

    public void reserverSeance() {
        System.out.println("[Adhérent] " + nom + " a initié une réservation.");
    }

    public Abonnement getAbonnement() {
        // Simulate retrieval of subscription details
        return this.abonnement;
    }
    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
    public Programme getProgramme() {
        return programme;
    }
    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
    
}