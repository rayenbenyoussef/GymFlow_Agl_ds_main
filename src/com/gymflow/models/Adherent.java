class Adherent extends Utilisateur {
    public Adherent(int id, String nom, String email) {
        super(id, nom, email);
    }

    public void reserverSeance() {
        System.out.println("[Adhérent] " + nom + " a initié une réservation.");
    }
}