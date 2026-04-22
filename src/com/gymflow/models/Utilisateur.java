abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;

    public Utilisateur(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
}