class Coach extends Utilisateur {
    public Coach(int id, String nom, String email, String password) {
        super(id, nom, email, password);
    }

    public void creerProgramme() {
        System.out.println("[Coach] " + nom + " crée un nouveau programme d'entraînement.");
    }
}