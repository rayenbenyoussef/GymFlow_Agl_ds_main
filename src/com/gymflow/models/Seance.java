import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Seance {
    private int id;
    private String type; // "Yoga", "Cardio", "Musculation"
    private LocalDateTime dateHeure;
    private int capaciteMax;
    private int placesReservees;
    private double prixDT; // Prix en Dinars Tunisiens

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Seance(int id, String type, LocalDateTime dateHeure, int capaciteMax, double prixDT) {
        this.id = id;
        this.type = type;
        this.dateHeure = dateHeure;
        this.capaciteMax = capaciteMax;
        this.prixDT = prixDT;
        this.placesReservees = 0;
    }

    // Getters
    public int getId() {
        return id;
    }


    public LocalDateTime getHeure() {
        return dateHeure;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getPlacesReservees() {
        return placesReservees;
    }

    public double getPrixDT() {
        return prixDT;
    }

    public String getType() {
        return type;
    }
   
   
    public String getNom() {
        return type;
    }
    


}