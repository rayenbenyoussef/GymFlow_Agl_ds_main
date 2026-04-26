class Coach extends Utilisateur {
    public Coach(int id, String nom, String email) {
        super(id, nom, email,12312,"123", "coach");
    }

    public void creerProgramme() {
        System.out.println("[Coach] " + nom + " crée un nouveau programme d'entraînement.");
    }
}