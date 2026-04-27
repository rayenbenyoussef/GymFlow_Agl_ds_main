import java.time.LocalDateTime;
import java.util.ArrayList;

class GestionnaireReservation {
    private static ArrayList<Seance> seances;
    private static ArrayList<Reservation> reservations;
    private static ArrayList<Abonnement> abonnements;

    private static int compteurReservation = 1;

    public GestionnaireReservation() {
        seances = new ArrayList<>();
        reservations = new ArrayList<>();
        abonnements = new ArrayList<>();
    }

    // ===== GESTION DES SÉANCES =====

    // Ajouter une nouvelle séance
    public void ajouterSeance(int id, String type, LocalDateTime dateHeure, int capacite, double prixDT) {
        // Vérifier que le type est valide
        if (!typeSeanceValide(type)) {
            System.out.println("Erreur : Type de séance invalide. Types acceptés : Yoga, Cardio, Musculation");
            return;
        }

        // Vérifier que la capacité est positive
        if (capacite <= 0) {
            System.out.println("Erreur : La capacité doit être positive.");
            return;
        }

        // Vérifier que le prix est positif
        if (prixDT < 0) {
            System.out.println("Erreur : Le prix ne peut pas être négatif.");
            return;
        }

        Seance seance = new Seance(id, type, dateHeure, capacite, prixDT);
        seances.add(seance);
        System.out.println("✓ Séance ajoutée : " + type + " pour " + prixDT + " DT");
    }

    // Valider les types de séance
    private boolean typeSeanceValide(String type) {
        return type.equals("Yoga") || type.equals("Cardio") || type.equals("Musculation");
    }

    // Rechercher les séances disponibles par type
    public ArrayList<Seance> rechercherSeancesDisponibles(String type) {
        ArrayList<Seance> seancesDisponibles = new ArrayList<>();

        for (Seance seance : seances) {
            if (seance.getType().equals(type) ) {
                seancesDisponibles.add(seance);
            }
        }

        if (seancesDisponibles.isEmpty()) {
            System.out.println("Aucune séance disponible pour le type : " + type);
        }

        return seancesDisponibles;
    }

    // Afficher toutes les séances
    public void afficherToutesSeances() {
        if (seances.isEmpty()) {
            System.out.println("Aucune séance disponible.");
            return;
        }

        System.out.println("\n=== TOUTES LES SÉANCES ===");
        for (Seance seance : seances) {
            System.out.println("- " + seance.getType() + " | " + seance.getHeure() +
                    " | " + seance.getNombrePlacesDisponibles() + "/" + seance.getCapaciteMax() +
                    " places | " + seance.getPrixDT() + " DT");
        }
        System.out.println("==========================\n");
    }

    // ===== GESTION DES RÉSERVATIONS =====

    // Réserver une séance pour un adhérent
    public boolean reserverSeance(int idAdherent, int idSeance, Facture facture) {
        // Trouver la séance
        Seance seance = trouverSeance(idSeance);
        if (seance == null) {
            System.out.println("Erreur : Séance non trouvée.");
            return false;
        }

        // Vérifier que l'adhérent a un abonnement valide
        Abonnement abonnement = trouverAbonnementAdherent(idAdherent);
        if (abonnement == null || !abonnement.estValide()) {
            System.out.println("Erreur : L'adhérent n'a pas d'abonnement valide.");
            return false;
        }

        // Créer la réservation
        Reservation reservation = new Reservation(compteurReservation++, idAdherent, idSeance, seance);

        // Confirmer la réservation
        if (!reservation.confirmer()) {
            return false;
        }

        // Ajouter à la liste
        reservations.add(reservation);

        // Ajouter le détail à la facture
        facture.ajouterDetail("Réservation " + seance.getType(), seance.getPrixDT());

        return true;
    }

    // Annuler une réservation
    public boolean annulerReservation(int idReservation, Facture facture) {
        Reservation reservation = trouverReservation(idReservation);
        if (reservation == null) {
            System.out.println("Erreur : Réservation non trouvée.");
            return false;
        }

        if (!reservation.annulationPossible()) {
            System.out.println("Erreur : Délai d'annulation insuffisant.");
            return false;
        }

        if (reservation.annuler()) {
            // Ajouter un crédit à la facture
            facture.ajouterDetail("Remboursement réservation", -reservation.getMontantPayeDT());
            return true;
        }

        return false;
    }

    // Afficher les réservations d'un adhérent
    public void afficherReservationsAdherent(int idAdherent) {
        ArrayList<Reservation> reservationsAdherent = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getIdAdherent() == idAdherent) {
                reservationsAdherent.add(reservation);
            }
        }

        if (reservationsAdherent.isEmpty()) {
            System.out.println("Aucune réservation pour cet adhérent.");
            return;
        }

        System.out.println("\n=== RÉSERVATIONS DE L'ADHÉRENT " + idAdherent + " ===");
        for (Reservation res : reservationsAdherent) {
            System.out.println("- Réservation #" + res.getId() + " | " + res.getSeanceAssociee().getType() +
                    " | Statut : " + res.getStatut() + " | " + res.getMontantPayeDT() + " DT");
        }
        System.out.println("==========================================\n");
    }

    // ===== GESTION DES ABONNEMENTS =====

    // Créer un abonnement pour un adhérent
    public Abonnement creerAbonnement(int idAdherent, String type, Facture facture) {
        // Vérifier que le type est valide
        Abonnement abonnement = new Abonnement(abonnements.size() + 1,idAdherent, type, "Actif");

        // Ajouter à la facture
        facture.ajouterDetail("Abonnement " + type, abonnement.getPrixDT());

        abonnements.add(abonnement);
        System.out.println("✓ Abonnement " + type + " créé pour l'adhérent " + idAdherent);

        return abonnement;
    }

    // Renouveler un abonnement
    public boolean renouvellerAbonnement(int idAdherent, Facture facture) {
        Abonnement abonnement = trouverAbonnementAdherent(idAdherent);
        if (abonnement == null) {
            System.out.println("Erreur : Aucun abonnement pour cet adhérent.");
            return false;
        }

        if (abonnement.renouveler()) {
            facture.ajouterDetail("Renouvellement " + abonnement.getType(), abonnement.getPrixDT());
            return true;
        }

        return false;
    }

    // ===== MÉTHODES UTILITAIRES =====

    // Trouver une séance
    private Seance trouverSeance(int idSeance) {
        for (Seance seance : seances) {
            if (seance.getId() == idSeance) {
                return seance;
            }
        }
        return null;
    }

    // Trouver une réservation
    private Reservation trouverReservation(int idReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == idReservation) {
                return reservation;
            }
        }
        return null;
    }

    // Trouver l'abonnement d'un adhérent
    private Abonnement trouverAbonnementAdherent(int idAdherent) {
        for (Abonnement abonnement : abonnements) {
            if (abonnement.getIdAdherent() == idAdherent) {
                return abonnement;
            }
        }
        return null;
    }

    // Getters
    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void reserverSeance(int id, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserverSeance'");
    }
}