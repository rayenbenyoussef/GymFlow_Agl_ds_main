class Admin extends Utilisateur {
    public Admin(int id, String nom, String email, String password) {
        super(id, nom, email, password);
    }

    public void voirStatistiques() {
        System.out.println("[Admin] " + nom + " consulte le tableau de bord.");
    }
}