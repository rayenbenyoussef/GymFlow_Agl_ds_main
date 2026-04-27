import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachMenu {

    private Scanner scanner = new Scanner(System.in);
    private Coach coach;

    // Temporary storage (you can replace with DB later)
    private List<Adherent> adherents = new ArrayList<>();
    private List<Programme> programmes = new ArrayList<>();
    private GestionnaireProgramme gestionnaireProgramme = new GestionnaireProgramme();

    public CoachMenu(Coach coach) {
        this.coach = coach;
    }
    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU COACH =====");
            System.out.println("1. Créer un programme d'entraînement");
            System.out.println("2. Ajouter un exercice à un programme");
            System.out.println("3. Supprimer un programme");
            System.out.println("4. Retour");
            System.out.print("Choix: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    voirAdherents();

                    System.out.print("Choisir l'id de l'adhérent: ");
                    int idAdherent = Integer.parseInt(scanner.nextLine());

                    System.out.print("Objectif (ex: Prise de masse): ");
                    String objectif = scanner.nextLine();

                    gestionnaireProgramme.ajouterProgramme(objectif,idAdherent);
                    break;
                
                case "2":
                    System.out.print("Choisir l'id de l'adhérent: ");
                    int idAdherentExo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nom de l'exercice: ");
                    String nom = scanner.nextLine();
                    System.out.print("Nombre de séries: ");
                    int series = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nombre de répétitions: ");
                    int repetitions = Integer.parseInt(scanner.nextLine());
                    gestionnaireProgramme.ajouterExercice(idAdherentExo, nom, series, repetitions);
                    break;
                case "3":
                    System.out.print("Choisir l'id de l'adhérent: ");
                    int idAdherentSuppr = Integer.parseInt(scanner.nextLine());
                    gestionnaireProgramme.supprimerProgramme(idAdherentSuppr);
                    break;
                case "4":   
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
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
   
}