import java.time.LocalDateTime;

class Seance {
    private String type;
    private LocalDateTime heure;
    private int places;

    public Seance(String type, LocalDateTime heure, int places) {
        this.type = type;
        this.heure = heure;
        this.places = places;
    }

    public void ajouterParticipant() {
        System.out.println("[Séance] Place réservée pour " + type + " à " + heure);
    }

    public String getType() {
        return type;
    }
   
    public LocalDateTime getHeure() {
        return heure;
    }
    public int getPlaces() {
        return places;
    }
    public String getNom() {
        return type;
    }
    public void decrementerPlaces() {
        if (places > 0) {
            places--;
        }
    }
    public void incrementerPlaces() {
        places++;
    }


}