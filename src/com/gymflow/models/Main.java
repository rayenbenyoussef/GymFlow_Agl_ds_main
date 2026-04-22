
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Programme programmeActuel = null;
        
        System.out.println("=== GymFlow : Module Programme (Sprint 2) ===");

        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Mode COACH (Créer un programme)");
            System.out.println("2. Mode ADHÉRENT (Suivre mon programme)");
            System.out.println("3. Quitter");
            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine(); // Nettoyage

            if (choix == 1) {
                // US : En tant que Coach, je veux créer un programme
                System.out.print("Nom du programme : ");
                String nomP = sc.nextLine();
                System.out.print("Objectif (ex: Prise de masse) : ");
                String obj = sc.nextLine();
                programmeActuel = new Programme(nomP, obj);

                System.out.print("Combien d'exercices ajouter ? ");
                int nb = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < nb; i++) {
                    System.out.println("Exercice #" + (i + 1));
                    System.out.print(" Nom : ");
                    String nomEx = sc.nextLine();
                    System.out.print(" Séries : ");
                    int s = sc.nextInt();
                    System.out.print(" Répétitions : ");
                    int r = sc.nextInt();
                    System.out.print(" Repos (sec) : ");
                    int rep = sc.nextInt();
                    sc.nextLine();
                    programmeActuel.ajouterExercice(new Exercice(nomEx, s, r, rep));
                }
                System.out.println("✅ Programme '" + nomP + "' créé avec succès !");

            } else if (choix == 2) {
                // US : En tant qu'adhérent, je veux consulter mon programme
                if (programmeActuel == null) {
                    System.out.println("⚠️ Aucun programme n'a été créé par le coach.");
                } else {
                    System.out.println("\n--- MON ENTRAÎNEMENT : " + programmeActuel.getNom() + " ---");
                    System.out.println("Objectif : " + programmeActuel.getObjectif());
                    
                    for (int i = 0; i < programmeActuel.getExercices().size(); i++) {
                        Exercice ex = programmeActuel.getExercices().get(i);
                        System.out.println(i + ". " + ex.toString());
                    }

                    System.out.println("\nProgression actuelle : " + programmeActuel.calculerProgression() + "%");
                    System.out.print("Entrez le numéro d'un exercice pour le marquer 'Terminé' (ou -1 pour retour) : ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < programmeActuel.getExercices().size()) {
                        programmeActuel.getExercices().get(index).marquerCommeTermine();
                        System.out.println("🔥 Bravo ! Progression mise à jour : " + programmeActuel.calculerProgression() + "%");
                    }
                }
            } else {
                break;
            }
        }
    }
}