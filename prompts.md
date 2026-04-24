# 📋 TABLE DES PROMPTS IA - GymFlow

## PROMPTS UTILISÉS PAR FONCTION - Équipe GymFlow

| # | Module | Fonction | Prompt Utilisé | Objectif |
|---|--------|----------|----------------|----------|
| 1 | **Abonnement** | `créerAbonnement()` | "Crée une méthode Java qui demande nom, type (Bronze/Argent/Or), prix en DT, dates début/fin, et statut. Valide les données et ajoute à ArrayList." | Création abonnements avec validation |
| 2 | **Abonnement** | `afficherTousLesAbonnements()` | "Affiche tous les abonnements avec numérotation. Gère liste vide. Ajoute séparateurs et résumé final du nombre total." | Affichage formaté liste complète |
| 3 | **Abonnement** | `modifierAbonnement()` | "Permets à un admin de modifier prix et statut d'un abonnement. Valide les changements et affiche confirmation." | Modification abonnements existants |
| 4 | **Abonnement** | `supprimerAbonnement()` | "Permet de supprimer un abonnement avec confirmation. Vérifie que personne n'est lié. Affiche message succès." | Suppression sécurisée abonnements |
| 5 | **Réservation** | `ajouterReservation()` | "Affiche list cours dispo. Demande choix. Vérifie places dispo (max 20). Empêche doublon réservation même adhérent. Décrémente places." | Ajout réservation avec contrôles |
| 6 | **Réservation** | `afficherMesReservations()` | "Affiche les réservations de l'adhérent connecté. Montre nom cours, date, statut. Gère cas vide avec message approprié." | Affichage réservations personnelles |
| 7 | **Réservation** | `annulerReservation()` | "Affiche réservations actives. Demande laquelle annuler. Vérifie délai > 1h avant cours. Si ok: supprime et remet place dispo. Sinon: refuse." | Annulation avec délai 1h minimum |
| 8 | **Réservation** | `rechercherCours()` | "Affiche tous les cours. Permet filtrer par type (Yoga/Cardio/Musculation). Montre places dispo pour chaque. Retourne cours choisi." | Recherche et filtrage cours |
| 9 | **Authentification** | `login()` | "Demande email/mdp. Cherche dans ArrayList<Utilisateur>. 3 tentatives max. Après 3 échecs: blocage 5 min. Si succès: retourne objet User." | Connexion sécurisée avec blocage |
| 10 | **Authentification** | `inscription()` | "Demande nom, email, password, rôle (Adhérent/Coach/Admin). Vérifie email unique. Hash password (SHA-256). Crée nouvel Utilisateur. Ajoute à liste." | Inscription nouvel utilisateur |
| 11 | **Authentification** | `menuAdherent()` | "Affiche menu: Réserver cours, Voir réservations, Annuler, Modifier profil, Voir abonnement, Quitter. Boucle jusqu'à quitter. Affiche nom connecté." | Menu contexte adhérent |
| 12 | **Authentification** | `menuCoach()` | "Affiche menu: Créer programme, Voir adhérents, Noter adhérent, Voir mes programmes, Quitter. Boucle jusqu'à quitter. Affiche nom connecté." | Menu contexte coach |
| 13 | **Authentification** | `menuAdmin()` | "Affiche menu: Gérer utilisateurs, Stats, Modifier tarifs (DT), Gérer abonnements, Rapports financiers, Quitter. Boucle jusqu'à quitter." | Menu contexte administrateur |
| 14 | **Authentification** | `afficherProfilUtilisateur()` | "Affiche profil complet: nom, email, rôle, date inscription, abonnement (si adhérent), programmes (si coach). Formaté avec symboles." | Affichage profil détaillé |
| 15 | **Programme** | `creerProgramme()` | "Coach saisit: nom programme, type (Yoga/Cardio/Musculation), durée semaines, nb exercices. Pour chaque exo: nom, séries, reps, durée minutes. Affiche résumé." | Création programme avec exercices |
| 16 | **Programme** | `calculerProgression()` | "Calcule % progression: (exercices terminés / total) * 100. Retourne objet avec %, nb terminés, temps restant estimé. Affiche barre visuelle [████░░]." | Calcul progression avec barre |
| 17 | **Programme** | `afficherMesProgrammes()` | "Adhérent voit ses programmes assignés. Pour chaque: nom, type, progression %, exos restants. Tri par progression. Affiche détails complets." | Affichage programmes adhérent |
| 18 | **Programme** | `marquerExerciceTermine()` | "Adhérent sélectionne exercice du programme. Marque comme 'Terminé'. Met à jour ArrayList<ProgressionExercice>. Recalcule progression globale programme." | Marquage exercice complété |
| 19 | **Programme** | `afficherExercicesProgramme()` | "Affiche tous les exercices d'un programme: numéro, nom, séries x reps, durée. Montre statut (Terminé/Pending). Ajoute temps total." | Affichage exercices détaillés |
| 20 | **Administration** | `afficherStatistiques()` | "Affiche dashboard: nb adhérents, coachs, abos actifs, réservations mois, revenu total DT, revenu moyen par abo, abo + populaire, cours + populaire." | Dashboard statistiques complet |
| 21 | **Administration** | `genererRapportFinancier()` | "Calcule: revenu mois (DT), revenu année (DT), revenu par type abo, dépenses estimées (salaires), bénéfice net. Affiche tableau Type|Qty|Prix|Total. Ajoute graphique ASCII." | Rapport financier détaillé |
| 22 | **Administration** | `gererUtilisateurs()` | "Admin voit liste utilisateurs: nom, email, rôle, date inscription. Peut: voir détails, désactiver compte, changer rôle, supprimer (avec confirmation)." | Gestion utilisateurs complet |
| 23 | **Administration** | `modifierTarifs()` | "Admin peut changer prix des abonnements (Bronze/Argent/Or) en DT. Affiche anciens prix. Demande nouveaux prix. Valide montants > 0. Confirme changement." | Modification tarifs abonnements |
| 24 | **Administration** | `gererAbonnements()` | "Admin voit tous abonnements. Peut: ajouter manuel, modifier statut (Actif/Inactif/Expiré), voir stats par type, générer rappels expiration." | Gestion abonnements complète |
| 25 | **Administration** | `afficherAbonnementsExpires()` | "Affiche abonnements expirant bientôt (< 7 jours). Montre: adhérent, date expiration, jours restants. Permet envoyer rappel/renouveller." | Alerte expirations prochaines |

---

## 📊 STATISTIQUES PROMPTS

- **Total Prompts:** 25
- **Modules:** 5
  - Abonnement: 4 prompts
  - Réservation: 4 prompts
  - Authentification: 5 prompts
  - Programme: 5 prompts
  - Administration: 7 prompts

---

## 🎯 POINTS CLÉS POUR CHAQUE PROMPT

✅ **Validation des données** (types, montants positifs, uniques)  
✅ **Montants en DT** (Dinar Tunisien systématique)  
✅ **Gestion des cas limites** (liste vide, doublon, dépassement capacité)  
✅ **Affichage formaté** (listes, tableaux, symboles)  
✅ **Logging/Traçabilité** (qui, quand, quoi)  
✅ **Sécurité** (validation, blocages, confirmations)
