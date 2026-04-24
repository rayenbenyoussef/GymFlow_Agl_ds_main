class Reservation {
    private Adherent adherent;
    private Seance seance;
    private String dateReservation;
    private String statut; // "Confirmée", "Annulée"

    public Reservation(Adherent adherent, Seance seance) {
        this.adherent = adherent;
        this.seance = seance;
        this.dateReservation = "19/04/2026"; // Date actuelle fictive
        this.statut = "En attente";
    }

    public void confirmer() {
        this.statut = "Confirmée";
        System.out.println("[Réservation] Statut mis à jour : " + statut);
    }

    public void annuler() {
        this.statut = "Annulée";
        System.out.println("[Réservation] La réservation a été annulée.");
    }
    public Seance getSeance() {
        return seance;
    }
}