public class Main {
    public static void main(String[] args) {
        // 1. Initialisation des acteurs
        Coach coachAhmed = new Coach(1, "Ahmed", "ahmed.coach@gym.tn");
        Adherent user1 = new Adherent(101, "Yassine", "yassine@email.com");

        System.out.println("=== DEBUT DU SCÉNARIO PROGRAMME ===");

        // --- USER STORY 1 : Création du programme par le Coach ---
        Programme p1 = coachAhmed.creerProgramme(
            "Full Body Express", 
            "Entraînement intense de 45min", 
            "Prise de masse"
        );
        p1.ajouterExercice("Développé Couché");
        p1.ajouterExercice("Squat");
        p1.ajouterExercice("Tractions");

        // --- USER STORY 2 : Suivi par l'Adhérent ---
        user1.seConnecter();
        p1.afficherProgramme();

        System.out.println("\n[Action] L'adhérent commence sa séance...");
        
        // Enregistrement des résultats (Poids, répétitions)
        p1.enregistrerPerformance("Développé Couché", 4, 10, 60.0);
        p1.enregistrerPerformance("Squat", 3, 12, 80.0);

        // Visualisation de la progression
        p1.afficherEvolution();
        
        System.out.println("\n=== FIN DU SCÉNARIO ===");
    }
}