class Admin extends Utilisateur {
    public Admin(int id, String nom, String email) {
        super(id, nom, email);
    }

    public void voirStatistiques() {
        System.out.println("[Admin] " + nom + " consulte le tableau de bord.");
    }
}