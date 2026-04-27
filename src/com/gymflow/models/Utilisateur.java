abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected int numTelephone;

    public Utilisateur(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public void seConnecter() {
        System.out.println("[Auth] " + nom + " est connecté avec succès.");
    }
    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}