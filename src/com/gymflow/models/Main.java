
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BIENVENUE DANS GYMFLOW - SYSTÈME COMPLET");
        System.out.println("========================================\n");

        // ===== INITIALISATION =====
        GestionnaireReservation gestionnaire = new GestionnaireReservation();
        
        // Créer des séances de test
        System.out.println("--- Création des séances ---");
        gestionnaire.ajouterSeance(1, "Yoga", LocalDateTime.of(2026, 4, 25, 10, 0), 15, 20.0);
        gestionnaire.ajouterSeance(2, "Cardio", LocalDateTime.of(2026, 4, 25, 14, 0), 20, 25.0);
        gestionnaire.ajouterSeance(3, "Musculation", LocalDateTime.of(2026, 4, 26, 16, 0), 10, 30.0);
        gestionnaire.ajouterSeance(4, "Yoga", LocalDateTime.of(2026, 4, 26, 9, 0), 12, 20.0);

        // Afficher toutes les séances
        gestionnaire.afficherToutesSeances();

        // ===== TEST D'ABONNEMENT ET FACTURE =====
        System.out.println("\n--- Création d'un abonnement pour l'adhérent 1 ---");
        Facture facture1 = new Facture(1);
        Abonnement abonnement1 = gestionnaire.creerAbonnement(1, "Mensuel", facture1);
        abonnement1.afficherDetails();

        // ===== TEST DE RÉSERVATION =====
        System.out.println("\n--- Réservation de séances pour l'adhérent 1 ---");
        gestionnaire.reserverSeance(1, 1, facture1); // Yoga
        gestionnaire.reserverSeance(1, 2, facture1); // Cardio

        // Afficher les réservations
        gestionnaire.afficherReservationsAdherent(1);

        // ===== AFFICHAGE ET PAIEMENT DE FACTURE =====
        System.out.println("\n--- Traitement de la facture ---");
        facture1.afficher();

        System.out.println("Paiement de la facture par carte...");
        facture1.payer("Carte bancaire", facture1.getMontantTTC() + 50); // Montant supérieur

        // ===== TEST RECHERCHE DE SÉANCES =====
        System.out.println("\n--- Recherche de séances disponibles ---");
        ArrayList<Seance> seancesYoga = gestionnaire.rechercherSeancesDisponibles("Yoga");
        System.out.println("Séances Yoga disponibles : " + seancesYoga.size());

        // ===== TEST AVEC UN DEUXIÈME ADHÉRENT =====
        System.out.println("\n--- Création d'un abonnement pour l'adhérent 2 ---");
        Facture facture2 = new Facture(2);
        Abonnement abonnement2 = gestionnaire.creerAbonnement(2, "Trimestriel", facture2);
        
        // Réserver la même séance Yoga
        gestionnaire.reserverSeance(2, 1, facture2);
        gestionnaire.reserverSeance(2, 3, facture2);

        gestionnaire.afficherReservationsAdherent(2);
        facture2.afficher();
        facture2.payer("Espèces", facture2.getMontantTTC());

        // ===== TEST D'ANNULATION AVEC DÉLAI =====
        System.out.println("\n--- Test d'annulation de réservation ---");
        System.out.println("Tentative d'annulation (si délai > 1h)...");
        // Note: L'annulation sera refusée car la séance est trop proche
        // gestionnaire.annulerReservation(1, facture1);

        // ===== AFFICHAGE FINAL =====
        System.out.println("\n========== RÉSUMÉ FINAL ==========");
        System.out.println("Total des séances : " + gestionnaire.getSeances().size());
        System.out.println("Total des réservations : " + gestionnaire.getReservations().size());
        System.out.println("Total des abonnements : " + gestionnaire.getAbonnements().size());
        System.out.println("==================================\n");
    }
}
