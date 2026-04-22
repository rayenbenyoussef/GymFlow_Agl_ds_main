class Adherent extends Utilisateur {
    private String motDePasse;

    public Adherent(int id, String nom, String email, String motDePasse) {
        super(id, nom, email);
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void afficherDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Nom: " + getNom());
        System.out.println("Email: " + getEmail());
    }

    public void reserverSeance() {
        System.out.println("[Adhérent] " + nom + " a initié une réservation.");

    }
}