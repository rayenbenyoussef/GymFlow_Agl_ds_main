class Adherent extends Utilisateur {
    public Adherent(int id, String nom, String email, String password) {
        super(id, nom, email, password);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void reserverSeance() {
        System.out.println("[Adhérent] " + nom + " a initié une réservation.");
    }
}