import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Facture {
    private int id;
    private int idAdherent;
    private LocalDate dateFacture;
    private ArrayList<String> details; // Description des services
    private double montantTotalDT;
    private String statut; // "Payée", "En attente", "Annulée"
    private String modePaiement; // "Espèces", "Carte", "Virement"

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static int compteurId = 1;

    public Facture(int idAdherent) {
        this.id = compteurId++;
        this.idAdherent = idAdherent;
        this.dateFacture = LocalDate.now();
        this.details = new ArrayList<>();
        this.montantTotalDT = 0;
        this.statut = "En attente";
        this.modePaiement = "";
    }

    // Ajouter un détail à la facture (ex: abonnement, réservation)
    public void ajouterDetail(String description, double montantDT) {
        if (montantDT < 0) {
            System.out.println("Erreur : Le montant ne peut pas être négatif.");
            return;
        }
        details.add(description + " : " + montantDT + " DT");
        montantTotalDT += montantDT;
        System.out.println("✓ Détail ajouté : " + description + " (" + montantDT + " DT)");
    }

    // Calculer la TVA (19% en Tunisie)
    public double calculerTVA() {
        return montantTotalDT * 0.19;
    }

    // Obtenir le montant TTC
    public double getMontantTTC() {
        return montantTotalDT + calculerTVA();
    }

    // Payer la facture
    public boolean payer(String modePaiement, double montantVerseeDT) {
        if (statut.equals("Payée")) {
            System.out.println("Erreur : Facture déjà payée.");
            return false;
        }

        if (montantVerseeDT < getMontantTTC()) {
            System.out.println("Erreur : Montant insuffisant. Requis : " + getMontantTTC() + " DT, " +
                    "Versé : " + montantVerseeDT + " DT");
            return false;
        }

        this.modePaiement = modePaiement;
        this.statut = "Payée";
        double monnaieRendue = montantVerseeDT - getMontantTTC();
        System.out.println("✓ Facture payée par " + modePaiement);
        if (monnaieRendue > 0) {
            System.out.println("✓ Monnaie rendue : " + monnaieRendue + " DT");
        }
        return true;
    }

    // Annuler la facture
    public boolean annuler() {
        if (statut.equals("Payée")) {
            System.out.println("Erreur : Impossible d'annuler une facture payée.");
            return false;
        }
        this.statut = "Annulée";
        System.out.println("✓ Facture annulée.");
        return true;
    }

    // Afficher la facture
    public void afficher() {
        System.out.println("\n========== FACTURE ==========");
        System.out.println("N° Facture : " + String.format("%04d", id));
        System.out.println("ID Adhérent : " + idAdherent);
        System.out.println("Date : " + dateFacture.format(formatter));
        System.out.println("--------- Détails ----------");
        for (String detail : details) {
            System.out.println(detail);
        }
        System.out.println("----------------------------");
        System.out.println("Sous-total : " + montantTotalDT + " DT");
        System.out.println("TVA (19%) : " + String.format("%.2f", calculerTVA()) + " DT");
        System.out.println("TOTAL TTC : " + String.format("%.2f", getMontantTTC()) + " DT");
        System.out.println("Statut : " + statut);
        if (!modePaiement.isEmpty()) {
            System.out.println("Mode de paiement : " + modePaiement);
        }
        System.out.println("============================\n");
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public double getMontantTotalDT() {
        return montantTotalDT;
    }

    public String getStatut() {
        return statut;
    }
}