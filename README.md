Il ne vous reste plus qu'à copier le bloc de code ci-dessous et à le coller dans un fichier nommé README.md à la racine de votre projet GitHub.
Markdown

# 🏋️‍♂️ GymFlow — Application intelligente de gestion de salle de sport

[![Figma Design](https://img.shields.io/badge/Figma-Design-F24E1E?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/files/team/1610878409329776945/project/589860077?fuid=1610878407351164491)
[![Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=java&logoColor=white)](#)
[![Methodology](https://img.shields.io/badge/Methodology-Agile%20Scrum-blue?style=for-the-badge)](#)

## 🎯 Pitch
**GymFlow** est une solution intelligente de gestion qui transforme l'expérience en salle de sport. En automatisant les processus critiques (abonnements, réservations, programmes), elle permet aux coachs de se concentrer sur l'humain et aux adhérents de maximiser leur motivation.

---

## ❗ Le challenge
Les salles de sport modernes souffrent souvent de :
* **Lourdeur administrative :** Gestion manuelle complexe des abonnements.
* **Saturation :** Manque de visibilité sur l'occupation des équipements.
* **Abandon :** Absence de suivi personnalisé pour les adhérents.

---

## 👥 Acteurs du système
* **Visiteur :** Accès aux informations et offres de la salle.
* **Adhérent :** Gestion autonome du profil, des réservations et suivi de progression.
* **Coach :** Création de programmes d'entraînement sur-mesure.
* **Administrateur :** Pilotage global, gestion des utilisateurs et statistiques financières.

---

## ⚙️ Fonctionnalités clés par module

* **🔐 Auth & Security (Fakhri) :** Système d'accès hiérarchisé (Admin/Adhérent/Coach) avec gestion sécurisée des profils.
* **🛠️ Admin Dashboard (Rayen) :** Statistiques de revenus en temps réel et gestion centralisée des membres.
* **💳 Smart Billing (Naceur) :** Souscription aux packs avec calcul automatique de la TVA (7%) et formatage monétaire en **Dinars Tunisiens (DT)**.
* **📅 Booking Engine (Yassine) :** Gestion intelligente des créneaux horaires avec contrôle strict des capacités de salle.
* **📊 Training Suite (Hamza) :** Suivi interactif des exercices avec indicateurs visuels de complétion (✔/❌).

---

## 🤖 L'Approche Hybride (IA + Humain)
Ce projet intègre une méthodologie de développement moderne :
1. **Génération IA :** Utilisation de prompts structurés pour le boilerplate et la logique algorithmique.
2. **Expertise Humaine :** Correction rigoureuse des règles métier, intégration des spécificités locales (DT/TVA) et optimisation de l'architecture POO.

---

## 🧱 Structure du projet

```text
GymFlow/
├── README.md
├── docs/
│   ├── rapport.pdf
│   └── captures/
├── diagrammes/
├── src/
│   └── com/gymflow/models/
└── tests/
```
---

## 🛠️ Technologies utilisées
- Java (console)
- Git & GitHub
- UML (PlantUML / StarUML)
- Figma (maquettes)

---

## 👨‍💻 Équipe

| Nom | Rôle Scrum | Fonctionnalité |
|-----|------------|----------------|
| Kaddour Fakhri | Product Owner | Authentification |
| Ben youssef Rayen | Scrum Master | Admin Dashboard |
| Fakhet Yassine | Développeur | Réservation |
| Gnichi Mohamed Naceur | Développeur | Abonnements |
| Jmili Hamza | Développeur | Programme |

---

## 🚀 Exécution du projet

### Compilation
```bash
javac -encoding UTF-8 -d out src/com/gymflow/models/*.java
```
### Exécution
```bash
java -cp out com.gymflow.models.Main
```
