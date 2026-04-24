class Admin extends Utilisateur {
    public Admin(int id, String nom, String email, int numTelephone) {
        super(id, nom, email,numTelephone, "admin");
    }

    public void voirStatistiques() {
        System.out.println("[Admin] " + nom + " consulte le tableau de bord.");
    }
}