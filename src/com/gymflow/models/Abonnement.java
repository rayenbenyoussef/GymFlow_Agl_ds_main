class Abonnement {
    private String type;
    private String statut;

    public Abonnement(String type, String statut) {
        this.type = type;
        this.statut = statut;
    }

    public void estValide() {
        System.out.println("[Abonnement] Statut : " + statut + " (Type: " + type + ")");
    }
}