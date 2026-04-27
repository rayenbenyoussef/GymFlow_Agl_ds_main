// Statistique.java
public class Statistique {
    public double totalRevenus;
    public int nombreAdherents;
    public int nombreReservations;
    public float tauxOccupation;

    // Logique métier : Simule le calcul des données depuis la base
    public void mettreAJourStats() {
        this.totalRevenus = 15750.450; // en DT
        this.nombreAdherents = 124;
        this.nombreReservations = 450;
        this.tauxOccupation = 72.5f;
    }
}