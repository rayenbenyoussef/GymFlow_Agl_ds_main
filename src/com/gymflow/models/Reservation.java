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

    // Confirmer la réservation et débiter le prix
    public boolean confirmer() {
        // Vérifier que la séance a des places disponibles
        if (!seanceAssociee.aDesPlacesDisponibles()) {
            System.out.println("Erreur : La séance est complète.");
            return false;
        }

        // Vérifier que la séance est dans le futur
        if (!seanceAssociee.estDansFutur()) {
            System.out.println("Erreur : La séance est passée.");
            return false;
        }

        // Réserver une place dans la séance
        if (!seanceAssociee.reserverPlace()) {
            return false;
        }

        // Débiter le montant
        this.montantPayeDT = seanceAssociee.getPrixDT();
        this.statut = "Confirmée";
        System.out.println("✓ Réservation confirmée. Montant débité : " + montantPayeDT + " DT");
        return true;
    }

    // Annuler la réservation si délai respecté
    public boolean annuler() {
        // Vérifier que la réservation est confirmée
        if (!statut.equals("Confirmée")) {
            System.out.println("Erreur : Seule une réservation confirmée peut être annulée.");
            return false;
        }

        // Vérifier le délai d'annulation (au moins 1h avant la séance)
        long heuresAvant = ChronoUnit.HOURS.between(LocalDateTime.now(), seanceAssociee.getDateHeure());
        if (heuresAvant < DELAI_ANNULATION_HEURES) {
            System.out.println("Erreur : Annulation possible au moins 1h avant la séance. " +
                    "Heures restantes : " + heuresAvant);
            return false;
        }

        // Libérer la place dans la séance
        seanceAssociee.annulerPlace();

        // Rembourser la totalité
        System.out.println("✓ Réservation annulée. Remboursement : " + montantPayeDT + " DT");
        this.montantPayeDT = 0;
        this.statut = "Annulée";
        return true;
    }

    // Vérifier si l'annulation est possible
    public boolean annulationPossible() {
        if (!statut.equals("Confirmée")) {
            return false;
        }
        long heuresAvant = ChronoUnit.HOURS.between(LocalDateTime.now(), seanceAssociee.getDateHeure());
        return heuresAvant >= DELAI_ANNULATION_HEURES;
    }

    // Afficher les détails de la réservation
    public void afficherDetails() {
        System.out.println("\n--- Détails de la réservation ---");
        System.out.println("ID Réservation: " + id);
        System.out.println("ID Adhérent: " + idAdherent);
        System.out.println("Type de séance: " + seanceAssociee.getType());
        System.out.println("Date de la séance: " + seanceAssociee.getDateHeure().format(formatter));
        System.out.println("Date de réservation: " + dateReservation.format(formatter));
        System.out.println("Statut: " + statut);
        System.out.println("Montant payé: " + montantPayeDT + " DT");
        System.out.println("---------------------------------");
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