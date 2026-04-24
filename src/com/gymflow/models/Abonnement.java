public class Abonnement {

    // Champs privés
    private String nomMembre;
    private String typeAbonnement;
    private double prix;
    private String dateDebut;
    private String dateFin;
    private String statut; // Actif, Expiré, En attente

    // Constructeur vide
    public Abonnement() {
    }

    // Constructeur avec paramètres
    public Abonnement(String nomMembre, String typeAbonnement, double prix,
                      String dateDebut, String dateFin, String statut) {
        this.nomMembre = nomMembre;
        this.typeAbonnement = typeAbonnement;
        this.prix = prix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    // Getters et Setters
    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(String typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    // Méthode afficherDetails()
    public void afficherDetails() {
        System.out.println("----- Détails de l'abonnement -----");
        System.out.println("Membre : " + nomMembre);
        System.out.println("Type : " + typeAbonnement);
        System.out.println("Prix : " + prix + " TND");
        System.out.println("Date début : " + dateDebut);
        System.out.println("Date fin : " + dateFin);
        System.out.println("Statut : " + statut);
        System.out.println("-----------------------------------");
    }
}