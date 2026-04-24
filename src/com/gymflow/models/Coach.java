class Coach extends Utilisateur {
    public Coach(int id, String nom, String email, int numTelephone) {
        super(id, nom, email,numTelephone, "coach");
    }

    public void creerProgramme() {
        System.out.println("[Coach] " + nom + " crée un nouveau programme d'entraînement.");
    }
}