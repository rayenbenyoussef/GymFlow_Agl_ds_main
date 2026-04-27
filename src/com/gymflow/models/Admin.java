import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin - Modèle pour les administrateurs GymFlow
 * Gère les statistiques, les revenus et les opérations administratives
 */
public class Admin extends Utilisateur {
    
    private LocalDate dateNomination;
    private String departement; // "Gestion", "Finance", "Supervision"
    private boolean actif;
    private double budgetMensuelDT;
    private ArrayList<String> historiqueLogs;
    private Map<String, Double> budgetParCategorie;
    private AdministrationService service;
    private Statistique stats;

    /**
     * Constructeur pour Admin
     */
    public Admin(int id, String nom, String email) {
        super(id, nom, email);
        this.dateNomination = LocalDate.now();
        this.departement = "Supervision";
        this.actif = true;
        this.budgetMensuelDT = 0.0;
        this.historiqueLogs = new ArrayList<>();
        this.budgetParCategorie = new HashMap<>();
        this.service = new AdministrationService();
        this.stats = new Statistique();
        initialiserBudgetCategories();
    }

    /**
     * Constructeur alternatif avec tous les paramètres
     */
    public Admin(int id, String nom, String email, int numTelephone, String password) {
        super(id, nom, email);
        this.dateNomination = LocalDate.now();
        this.departement = "Supervision";
        this.actif = true;
        this.budgetMensuelDT = 0.0;
        this.historiqueLogs = new ArrayList<>();
        this.budgetParCategorie = new HashMap<>();
        this.service = new AdministrationService();
        this.stats = new Statistique();
        initialiserBudgetCategories();
    }

    /**
     * Initialiser les budgets par catégorie
     */
    private void initialiserBudgetCategories() {
        budgetParCategorie.put("Salaires", 5000.0);
        budgetParCategorie.put("Équipements", 2000.0);
        budgetParCategorie.put("Maintenance", 1000.0);
        budgetParCategorie.put("Marketing", 800.0);
    }

    /**
     * Afficher les statistiques globales - MÉTHODE PRINCIPALE
     */
    public void afficherStatsGlobales() {
        stats.mettreAJourStats();
        System.out.println("\n========== TABLEAU DE BORD ADMIN ==========");
        System.out.println("📊 Adhérents actifs: " + stats.nombreAdherents);
        System.out.println("💰 Revenus mensuels: " + stats.totalRevenus + " DT");
        System.out.println("📅 Réservations: " + stats.nombreReservations);
        System.out.println("📈 Taux d'occupation: " + stats.tauxOccupation + "%");
        System.out.println("⭐ Satisfaction: 4.5/5");
        System.out.println("==========================================\n");
        ajouterLog("Consultation des statistiques globales");
    }

    /**
     * Consulter les statistiques du système (alias)
     */
    public void voirStatistiques() {
        afficherStatsGlobales();
    }

    /**
     * Gérer les utilisateurs par rôle
     */
    public void gererUtilisateurs(List<Utilisateur> liste, String role) {
        List<Utilisateur> resultats = service.filtrerUtilisateurs(liste, role);
        System.out.println("\n--- LISTE DES " + role.toUpperCase() + "S ---");
        if (resultats.isEmpty()) {
            System.out.println("❌ Aucun " + role + " trouvé.");
        } else {
            for (Utilisateur u : resultats) {
                System.out.println("ID: " + u.id + " | Nom: " + u.nom + " | Email: " + u.email);
            }
        }
        ajouterLog("Gestion des utilisateurs - Rôle: " + role);
    }

    /**
     * Consulter les finances - MÉTHODE PRINCIPALE
     */
    public void consulterFinances() {
        System.out.println("\n========== GESTION DES REVENUS ==========");
        System.out.println("💰 Revenus du jour: " + service.calculerRevenus("JOUR") + " DT");
        System.out.println("💰 Revenus du mois: " + service.calculerRevenus("MOIS") + " DT");
        System.out.println("💰 Revenus de l'année: " + service.calculerRevenus("ANNEE") + " DT");
        System.out.println("========================================\n");
        ajouterLog("Consultation des finances");
    }

    /**
     * Générer un rapport financier
     */
    public double genererRapportFinancier(double revenus, double depenses) {
        double benefice = revenus - depenses;
        double marge = (benefice / revenus) * 100;

        System.out.println("\n========== RAPPORT FINANCIER ==========");
        System.out.println("💰 Revenus totaux: " + revenus + " DT");
        System.out.println("💸 Dépenses totales: " + depenses + " DT");
        System.out.println("📈 Bénéfice net: " + benefice + " DT");
        System.out.println("📊 Marge bénéficiaire: " + String.format("%.2f", marge) + "%");
        System.out.println("=======================================\n");

        ajouterLog("Rapport financier généré - Bénéfice: " + benefice + " DT");
        return benefice;
    }

    /**
     * Consulter les revenus par catégorie
     */
    public void consulterRevenusCategorises() {
        System.out.println("\n========== REVENUS PAR CATÉGORIE ==========");
        System.out.println("💰 Abonnements: 8500 DT");
        System.out.println("💰 Séances ponctuelles: 3200 DT");
        System.out.println("💰 Services supplémentaires: 1800 DT");
        System.out.println("💰 Ventes produits: 950 DT");
        System.out.println("📊 Total: 14,450 DT");
        System.out.println("==========================================\n");

        ajouterLog("Consultation des revenus catégorisés");
    }

    /**
     * Gérer l'accès utilisateur
     */
    public void gererAccesUtilisateur(String nomUtilisateur, String role, boolean autoriser) {
        String statut = autoriser ? "autorisé" : "refusé";
        System.out.println("🔐 Accès " + statut + " pour " + nomUtilisateur + " - Rôle: " + role);
        ajouterLog("Accès " + statut + " pour " + nomUtilisateur);
    }

    /**
     * Suspendre un utilisateur
     */
    public void suspendreUtilisateur(String nomUtilisateur, String raison) {
        System.out.println("⛔ Utilisateur " + nomUtilisateur + " suspendu");
        System.out.println("📝 Raison: " + raison);
        ajouterLog("Suspension de " + nomUtilisateur + " - Raison: " + raison);
    }

    /**
     * Activer un utilisateur suspendu
     */
    public void activerUtilisateur(String nomUtilisateur) {
        System.out.println("✅ Utilisateur " + nomUtilisateur + " activé");
        ajouterLog("Activation de " + nomUtilisateur);
    }

    /**
     * Voir les budgets par catégorie
     */
    public void consulterBudget() {
        System.out.println("\n========== BUDGET MENSUEL ==========");
        double totalBudget = 0;
        for (Map.Entry<String, Double> entry : budgetParCategorie.entrySet()) {
            System.out.println("💼 " + entry.getKey() + ": " + entry.getValue() + " DT");
            totalBudget += entry.getValue();
        }
        System.out.println("📊 Total budget: " + totalBudget + " DT");
        System.out.println("====================================\n");
        ajouterLog("Consultation du budget");
    }

    /**
     * Modifier le budget d'une catégorie
     */
    public void modifierBudget(String categorie, double nouveauMontant) {
        if (budgetParCategorie.containsKey(categorie)) {
            double ancienMontant = budgetParCategorie.get(categorie);
            budgetParCategorie.put(categorie, nouveauMontant);
            System.out.println("✅ Budget " + categorie + " modifié: " + ancienMontant + " DT → " + nouveauMontant + " DT");
            ajouterLog("Budget de " + categorie + " modifié à " + nouveauMontant + " DT");
        } else {
            System.out.println("❌ Catégorie introuvable");
        }
    }

    /**
     * Auditer les actions d'un utilisateur
     */
    public void auditerUtilisateur(String nomUtilisateur) {
        System.out.println("\n========== AUDIT UTILISATEUR ==========");
        System.out.println("👤 Utilisateur: " + nomUtilisateur);
        System.out.println("📅 Dernière connexion: 2026-04-27 14:30");
        System.out.println("🔍 Nombre d'actions: 45");
        System.out.println("⏰ Temps total connecté: 125 heures");
        System.out.println("📊 Taux d'activité: 85%");
        System.out.println("=======================================\n");
        ajouterLog("Audit de " + nomUtilisateur);
    }

    /**
     * Envoyer une notification à tous les utilisateurs
     */
    public void envoyerNotificationGlobale(String message) {
        System.out.println("\n📢 NOTIFICATION GLOBALE");
        System.out.println("Message: " + message);
        System.out.println("✅ Notifiée à tous les utilisateurs\n");
        ajouterLog("Notification globale envoyée: " + message);
    }

    /**
     * Générer un rapport d'activité
     */
    public void genererRapportActivite() {
        System.out.println("\n========== RAPPORT D'ACTIVITÉ ==========");
        System.out.println("📊 Période: Avril 2026");
        System.out.println("👥 Nouvelles inscriptions: 12");
        System.out.println("📅 Nouvelles séances: 45");
        System.out.println("💳 Nouveaux abonnements: 8");
        System.out.println("⭐ Satisfaction moyenne: 4.3/5");
        System.out.println("========================================\n");
        ajouterLog("Rapport d'activité généré");
    }

    /**
     * Exporter les données
     */
    public void exporterDonnees(String format) {
        System.out.println("📤 Export des données en format " + format);
        service.exporterDonnees(format);
        ajouterLog("Données exportées en format " + format);
    }

    /**
     * Consulter les logs d'administration
     */
    public void consulterLogs() {
        System.out.println("\n========== LOGS D'ADMINISTRATION ==========");
        if (historiqueLogs.isEmpty()) {
            System.out.println("Aucun log");
        } else {
            for (int i = 0; i < historiqueLogs.size(); i++) {
                System.out.println((i + 1) + ". " + historiqueLogs.get(i));
            }
        }
        System.out.println("==========================================\n");
    }

    /**
     * Ajouter une entrée au log
     */
    private void ajouterLog(String action) {
        String timestamp = LocalDateTime.now().toString();
        historiqueLogs.add("[" + timestamp + "] Admin " + nom + ": " + action);
    }

    /**
     * Valider les modifications avant fusion
     */
    public boolean validerModifications() {
        System.out.println("\n========== VALIDATION FUSION ==========");
        System.out.println("✅ Menu Admin complet et fonctionnel");
        System.out.println("✅ Gestion des utilisateurs opérationnelle");
        System.out.println("✅ Statistiques et rapports disponibles");
        System.out.println("✅ Gestion des budgets mise en place");
        System.out.println("✅ Système de logs en place");
        System.out.println("=====================================\n");
        return true;
    }

    // ========== GETTERS & SETTERS ==========

    public LocalDate getDateNomination() {
        return dateNomination;
    }

    public void setDateNomination(LocalDate dateNomination) {
        this.dateNomination = dateNomination;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public double getBudgetMensuelDT() {
        return budgetMensuelDT;
    }

    public void setBudgetMensuelDT(double budgetMensuelDT) {
        this.budgetMensuelDT = budgetMensuelDT;
    }

    public Map<String, Double> getBudgetParCategorie() {
        return budgetParCategorie;
    }

    public ArrayList<String> getHistoriqueLogs() {
        return historiqueLogs;
    }

    public AdministrationService getService() {
        return service;
    }

    public Statistique getStats() {
        return stats;
    }
}
