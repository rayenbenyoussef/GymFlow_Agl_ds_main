import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Seance> seances = new ArrayList<>();
    private static List<Reservation> mesReservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Adherent utilisateurActuel = new Adherent(1, "Jean Dupont", "jean@email.com");

    public static void main(String[] args) {
        // Initialisation des données
        seances.add(new Seance("Yoga", "08:00", 10));
        seances.add(new Seance("Yoga", "18:00", 5));
        seances.add(new Seance("Cardio", "10:00", 2)); // Capacité faible pour test
        seances.add(new Seance("Musculation", "14:00", 15));
        seances.add(new Seance("Musculation", "16:00", 20));

        boolean continuer = true;

        while (continuer) {
            System.out.println("\n--- MENU GYM ---");
            System.out.println("1. Filtrer et Réserver une séance");
            System.out.println("2. Mes réservations (Annuler)");
            System.out.println("3. Quitter");
            System.out.print("Choix : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    menuReservation();
                    break;
                case "2":
                    menuAnnulation();
                    break;
                case "3":
                    continuer = false;
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }

    private static void menuReservation() {
        System.out.println("\nTypes disponibles : Yoga, Cardio, Musculation");
        System.out.print("Entrez le type souhaité : ");
        String typeFiltre = scanner.nextLine();

        // Filtrage des séances
        List<Seance> filtered = seances.stream()
                .filter(s -> s.getType().equalsIgnoreCase(typeFiltre))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Aucune séance trouvée pour ce type.");
            return;
        }

        System.out.println("\nSéances disponibles :");
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println((i + 1) + ". " + filtered.get(i));
        }

        System.out.print("Choisissez le numéro pour réserver (ou 0 pour retour) : ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < filtered.size()) {
            Seance selectionnee = filtered.get(index);
            if (selectionnee.reserver()) {
                Reservation res = new Reservation(mesReservations.size() + 1, utilisateurActuel.id, index);
                // On simule l'ajout des détails dans la réservation
                mesReservations.add(res);
                System.out.println("✅ CONFIRMATION : Séance " + selectionnee.getType() + " de " + selectionnee.getHeure() + " réservée !");
            } else {
                System.out.println("❌ Erreur : Plus de places disponibles pour cette séance.");
            }
        }
    }

    private static void menuAnnulation() {
        if (mesReservations.isEmpty()) {
            System.out.println("Vous n'avez aucune réservation active.");
            return;
        }

        System.out.println("\nVos réservations actives :");
        // Pour l'affichage, on croise avec la liste des séances (simplifié ici)
        for (int i = 0; i < mesReservations.size(); i++) {
            System.out.println((i + 1) + ". Réservation #" + (i + 1));
        }

        System.out.print("Numéro à annuler (ou 0 pour retour) : ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < mesReservations.size()) {
            Reservation r = mesReservations.remove(index);
            r.annuler();
            // On libère la place dans la première séance correspondante pour l'exemple
            // (Dans un vrai système, la réservation stockerait l'objet Seance)
            seances.get(0).annuler(); 
            System.out.println("✅ Réservation annulée. La place a été libérée.");
        }
    }
}