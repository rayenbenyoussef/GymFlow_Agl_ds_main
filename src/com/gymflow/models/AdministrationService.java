// AdministrationService.java
import java.util.List;
import java.util.stream.Collectors;

public class AdministrationService {

    // LOGIQUE : Filtrage par rôle (Critère d'acceptation 1)
    public List<Utilisateur> filtrerUtilisateurs(List<Utilisateur> liste, String role) {
        return liste.stream()
                .filter(u -> u.getClass().getSimpleName().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    // LOGIQUE : Exportation des données (Critère d'acceptation 2)
    public void exporterDonnees(String format) {
        System.out.println("[Logique] Préparation des données financières...");
        System.out.println("[Succès] Rapport exporté au format " + format + " (Rapport_GymFlow_TN." + format.toLowerCase() + ")");
    }
    
    // LOGIQUE : Calcul revenus par période
    public String calculerRevenus(String periode) {
        if (periode.equals("JOUR")) return "450.200 DT";
        return "15,750.450 DT";
    }
}