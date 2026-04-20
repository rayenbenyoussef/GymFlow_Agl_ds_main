class Statistique {
    private double totalRevenus;
    private int nombreAdherents;

    public Statistique(double totalRevenus, int nombreAdherents) {
        this.totalRevenus = totalRevenus;
        this.nombreAdherents = nombreAdherents;
    }

    public void calculerStats() {
        System.out.println("--- STATS ADMIN ---");
        System.out.println("Total Revenus : " + totalRevenus + " DT");
        System.out.println("Adhérents actifs : " + nombreAdherents);
    }
}