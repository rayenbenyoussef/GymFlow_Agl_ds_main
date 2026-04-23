import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Abonnement {
    private int id;
    private int idAdherent;
    private String type; // "Mensuel", "Trimestriel", "Annuel"
    private double prixDT; // Prix en Dinars Tunisiens
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut; // "Actif", "Expiré", "Suspendu"

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Tarifs pour différents types d'abonnement (en DT)
    private static final double PRIX_MENSUEL = 50.0;
    private static final double PRIX_TRIMESTRIEL = 130.0; // Économie de 10 DT
    private static final double PRIX_ANNUEL = 450.0; // Économie de 150 DT

    public Abonnement(int id, int idAdherent, String type) {
        this.id = id;
        this.idAdherent = idAdherent;
        this.type = validerType(type);
        this.dateDebut = LocalDate.now();
        this.dateFin = calculerDateFin();
        this.prixDT = obtenirPrix();
        this.statut = "Actif";
    }

    // Valider le type d'abonnement
    private String validerType(String type) {
        if (type.equals("Mensuel") || type.equals("Trimestriel") || type.equals("Annuel")) {
            return type;
        }
        System.out.println("Erreur : Type d'abonnement invalide. Défaut : Mensuel");
        return "Mensuel";
    }

    // Calculer la date de fin selon le type
    private LocalDate calculerDateFin() {
        switch (type) {
            case "Mensuel":
                return dateDebut.plusMonths(1);
            case "Trimestriel":
                return dateDebut.plusMonths(3);
            case "Annuel":
                return dateDebut.plusYears(1);
            default:
                return dateDebut.plusMonths(1);
        }
    }

    // Obtenir le prix selon le type
    private double obtenirPrix() {
        switch (type) {
            case "Mensuel":
                return PRIX_MENSUEL;
            case "Trimestriel":
                return PRIX_TRIMESTRIEL;
            case "Annuel":
                return PRIX_ANNUEL;
            default:
                return PRIX_MENSUEL;
        }
    }

    // Vérifier si l'abonnement est valide (actif et pas expiré)
    public boolean estValide() {
        if (statut.equals("Actif") && LocalDate.now().isBefore(dateFin)) {
            return true;
        }
        if (statut.equals("Actif") && LocalDate.now().isAfter(dateFin)) {
            this.statut = "Expiré";
        }
        return false;
    }

    // Renouveler l'abonnement
    public boolean renouveler() {
        if (statut.equals("Suspendu")) {
            System.out.println("Erreur : Impossible de renouveler un abonnement suspendu.");
            return false;
        }

        this.dateDebut = LocalDate.now();
        this.dateFin = calculerDateFin();
        this.statut = "Actif";
        System.out.println("✓ Abonnement renouvelé. Nouvelle date d'expiration : " + 
                           dateFin.format(formatter));
        return true;
    }

    // Suspendre l'abonnement
    public void suspendre() {
        this.statut = "Suspendu";
        System.out.println("✓ Abonnement suspendu.");
    }

    // Réactiver l'abonnement
    public boolean reactiver() {
        if (!statut.equals("Suspendu")) {
            System.out.println("Erreur : Impossible de réactiver un abonnement non suspendu.");
            return false;
        }
        this.statut = "Actif";
        System.out.println("✓ Abonnement réactivé.");
        return true;
    }

    // Obtenir les jours restants
    public long getJoursRestants() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dateFin);
    }

    // Afficher les détails de l'abonnement
    public void afficherDetails() {
        System.out.println("\n--- Détails de l'abonnement ---");
        System.out.println("ID Abonnement: " + id);
        System.out.println("ID Adhérent: " + idAdherent);
        System.out.println("Type: " + type);
        System.out.println("Prix: " + prixDT + " DT");
        System.out.println("Date de début: " + dateDebut.format(formatter));
        System.out.println("Date d'expiration: " + dateFin.format(formatter));
        System.out.println("Jours restants: " + getJoursRestants());
        System.out.println("Statut: " + statut + " " + (estValide() ? "✓" : "✗"));
        System.out.println("-------------------------------");
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public String getType() {
        return type;
    }

    public double getPrixDT() {
        return prixDT;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public String getStatut() {
        return statut;
    }
}