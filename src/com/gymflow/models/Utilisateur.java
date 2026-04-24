
abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected int numTelephone;
    protected String role;

    public Utilisateur(int id, String nom, String email, int numTelephone, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.numTelephone = numTelephone;
        this.role = role;
    }

    public void seConnecter() {
        System.out.println("[Auth] " + nom + " est connecté avec succès.");
    }
    public String getRole() {
        return this.role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }
}