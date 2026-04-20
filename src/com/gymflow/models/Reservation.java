class Reservation {
    private int id;
    private int idAdherent;
    private int idSeance;
    private String dateReservation;
    private String statut; // "Confirmée", "Annulée"

    public Reservation(int id, int idAdherent, int idSeance) {
        this.id = id;
        this.idAdherent = idAdherent;
        this.idSeance = idSeance;
        this.dateReservation = "19/04/2026"; // Date actuelle fictive
        this.statut = "En attente";
    }

    public void confirmer() {
        this.statut = "Confirmée";
        System.out.println("[Réservation] Statut mis à jour : " + statut);
    }

    public void annuler() {
        this.statut = "Annulée";
        System.out.println("[Réservation] La réservation #" + id + " a été annulée.");
    }
}