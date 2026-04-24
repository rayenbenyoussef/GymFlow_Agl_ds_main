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

    // Vérifier si la séance a de la place disponible
    public boolean aDesPlacesDisponibles() {
        return placesReservees < capaciteMax;
    }

    // Obtenir le nombre de places disponibles
    public int getNombrePlacesDisponibles() {
        return capaciteMax - placesReservees;
    }

    // Réserver une place (si disponible)
    public boolean reserverPlace() {
        if (!aDesPlacesDisponibles()) {
            System.out.println("Erreur : La séance " + type + " est complète.");
            return false;
        }
        placesReservees++;
        System.out.println("✓ Place réservée. Places restantes : " + getNombrePlacesDisponibles());
        return true;
    }

    // Annuler une réservation (libérer une place)
    public boolean annulerPlace() {
        if (placesReservees > 0) {
            placesReservees--;
            System.out.println("✓ Place libérée. Places restantes : " + getNombrePlacesDisponibles());
            return true;
        }
        System.out.println("Erreur : Aucune place à libérer.");
        return false;
    }
    
    // Afficher les détails de la séance
    public void afficherDetails() {
        System.out.println("\n--- Détails de la séance ---");
        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Date/Heure: " + dateHeure.format(formatter));
        System.out.println("Capacité: " + capaciteMax + " places");
        System.out.println("Places disponibles: " + getNombrePlacesDisponibles());
        System.out.println("Prix: " + prixDT + " DT");
        System.out.println("----------------------------");
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateHeure() {
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
}