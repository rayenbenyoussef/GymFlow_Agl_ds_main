class Coach extends Utilisateur {
    public Coach(int id, String nom, String email) {
        super(id, nom, email);
    }

    public Programme creerProgramme(String titre, String desc, String obj) {
        System.out.println("[Coach] " + nom + " crée le programme : " + titre);
        return new Programme(titre, desc, obj);
    }
}