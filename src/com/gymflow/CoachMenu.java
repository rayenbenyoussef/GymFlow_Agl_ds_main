

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachMenu {

    private Scanner scanner = new Scanner(System.in);
    private Coach coach;

    // Temporary storage (you can replace with DB later)
    private List<Adherent> adherents = new ArrayList<>();
    private List<Programme> programmes = new ArrayList<>();

    public CoachMenu(Coach coach) {
        this.coach = coach;
    }
    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU COACH =====");
            System.out.println("1. Créer un programme d'entraînement");
            System.out.println("2. Voir les adhérents");
            System.out.println("3. Ajouter un exercice à un programme");
            System.out.println("4. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    creerProgramme();
                    break;
                case "2":
                    voirAdherents();
                    break;
                case "3":
                    ajouterExercice();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // ✅ 1. Create program
    private void creerProgramme() {
        if (adherents.isEmpty()) {
            System.out.println("Aucun adhérent disponible.");
            return;
        }

        voirAdherents();
        System.out.print("Choisir l'index de l'adhérent: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= adherents.size()) {
            System.out.println("Index invalide.");
            return;
        }

        Adherent adherent = adherents.get(index);

        System.out.print("Objectif (ex: Prise de masse): ");
        String objectif = scanner.nextLine();

        Programme programme = new Programme(objectif, adherent);
        programmes.add(programme);

        System.out.println("Programme créé avec succès !");
    }

    // ✅ 2. Show adherents
    private void voirAdherents() {
        if (adherents.isEmpty()) {
            System.out.println("Aucun adhérent.");
            return;
        }

        for (int i = 0; i < adherents.size(); i++) {
            System.out.println(i + " - " + adherents.get(i).getNom());
        }
    }

    // ✅ 3. Add exercise
    private void ajouterExercice() {
        if (programmes.isEmpty()) {
            System.out.println("Aucun programme disponible.");
            return;
        }

        // Show programs
        for (int i = 0; i < programmes.size(); i++) {
            System.out.println(i + " - " + programmes.get(i).getObjectif());
        }

        System.out.print("Choisir un programme: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= programmes.size()) {
            System.out.println("Index invalide.");
            return;
        }

        Programme programme = programmes.get(index);

        System.out.print("Nom de l'exercice: ");
        String nom = scanner.nextLine();

        System.out.print("Nombre de séries: ");
        int series = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre de répétitions: ");
        int repetitions = Integer.parseInt(scanner.nextLine());

        Exercice exercice = new Exercice(nom, series, repetitions);

        programme.ajouterExercice(exercice);

        System.out.println("Exercice ajouté !");
    }

    // 👉 Just for testing (add fake adherents)
    public void addDummyData() {
        Abonnement a1 = new Abonnement("Mensuel", "Actif");
        Abonnement a2 = new Abonnement("Annuel", "Actif");
        Programme p1 = new Programme("Perte de poids", null);
        Programme p2 = new Programme("Prise de masse", null);
        adherents.add(new Adherent(1, "Alice","zeze@fdsgsd.vcb", 12345678, a1,p1));
        adherents.add(new Adherent(2, "Bob","zeze@fdsgsd", 12345678, a2,p1));
    }
}