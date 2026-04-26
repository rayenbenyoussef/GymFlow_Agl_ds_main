import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Reservation {

    private int id;
    private int idAdherent;
    private int idSeance;
    private LocalDate dateReservation;
    private String statut; // "En attente", "Confirmée", "Annulée"
    private double montantPayeDT; // Montant payé en DT
    private Seance seanceAssociee;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final long DELAI_ANNULATION_HEURES = 1; // Délai minimum pour annuler

    public Reservation(int id, int idAdherent, int idSeance, Seance seance) {
        this.id = id;
        this.idAdherent = idAdherent;
        this.idSeance = idSeance;
        this.seanceAssociee = seance;
        this.dateReservation = LocalDate.now();
        this.statut = "En attente";
        this.montantPayeDT = 0;
    }

  
  

    // Vérifier si l'annulation est possible
    public boolean annulationPossible() {
        if (!statut.equals("Confirmée")) {
            return false;
        }
        long heuresAvant = ChronoUnit.HOURS.between(LocalDateTime.now(), seanceAssociee.getHeure());
        return heuresAvant >= DELAI_ANNULATION_HEURES;
    }


    // Getters
    public int getId() {
        return id;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public String getStatut() {
        return statut;
    }

    public double getMontantPayeDT() {
        return montantPayeDT;
    }

    public Seance getSeanceAssociee() {
        return seanceAssociee;
    }
}