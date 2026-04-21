// Admin.java
import java.util.List;

public class Admin extends Utilisateur {
    private AdministrationService service = new AdministrationService();
    private Statistique stats = new Statistique();

    public Admin(int id, String nom, String email) {
        super(id, nom, email);
    }

    public void afficherStatsGlobales() {
        stats.mettreAJourStats();
        System.out.println("\n--- TABLEAU DE BORD (TUNISIE) ---");
        System.out.println("Adhérents actifs : " + stats.nombreAdherents);
        System.out.println("Revenus mensuels : " + stats.totalRevenus + " DT");
        System.out.println("Réservations : " + stats.nombreReservations);
        System.out.println("Taux d'occupation : " + stats.tauxOccupation + "%");
    }

    public void gererUtilisateurs(List<Utilisateur> liste, String role) {
        List<Utilisateur> resultats = service.filtrerUtilisateurs(liste, role);
        System.out.println("\n--- LISTE DES " + role.toUpperCase() + "S ---");
        for (Utilisateur u : resultats) {
            System.out.println("ID: " + u.id + " | Nom: " + u.nom + " | Email: " + u.email);
        }
    }

    public void consulterFinances() {
        System.out.println("\n--- GESTION DES REVENUS ---");
        System.out.println("Revenus du jour : " + service.calculerRevenus("JOUR"));
        System.out.println("Revenus du mois : " + service.calculerRevenus("MOIS"));
        service.exporterDonnees("Excel");
    }
}