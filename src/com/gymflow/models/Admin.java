class Admin extends Utilisateur {

    public Admin(int id, String nom, String email, int numTelephone, String password) {
        super(id, nom, email,numTelephone, password, "admin");

    }

    public void voirStatistiques() {
        System.out.println("[Admin] " + nom + " consulte le tableau de bord.");
    }
}