# 🏋️‍♂️ GymFlow — Application intelligente de gestion de salle de sport

## 🎯 Pitch
GymFlow est une solution intelligente de gestion de salles de sport qui automatise le suivi des abonnements et la réservation des équipements. Elle offre aux adhérents un accompagnement personnalisé et aux coachs un outil de suivi de performance pour maximiser la motivation et l'organisation de la salle.

---

## ❗ Problème
Les salles de sport rencontrent plusieurs difficultés :
- gestion manuelle des abonnements  
- absence de suivi personnalisé  
- surcharge des machines  
- manque d’outils de motivation  

---

## 👥 Acteurs
- **Visiteur** : consulter les informations  
- **Client (Adhérent)** : gérer abonnement et réservations  
- **Coach** : créer programmes d’entraînement  
- **Administrateur** : gérer la plateforme  

---

## ⚙️ Fonctionnalités principales

### 🔐 Authentification & Profil
- Inscription / Connexion  
- Gestion des informations personnelles  

### 💳 Gestion des abonnements
- Souscription à un abonnement  
- Vérification de validité  
- Notification d’expiration  

### 📅 Réservation des séances
- Réservation de créneaux  
- Consultation du planning  
- Annulation  

### 📊 Programme d’entraînement
- Création par le coach  
- Suivi des exercices  
- Historique des performances  

### 🛠️ Dashboard Admin
- Gestion des utilisateurs  
- Statistiques (revenus, fréquentation)  

---

## 🤖 Bonus (Innovation)
- Recommandation automatique de programmes  
- Notifications (séances, abonnements)  
- Système de motivation (badges)  

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
| Ben youssef Rayen | Product Owner | Admin Dashboard |
| KAddour Fakhri | Scrum Master | Authentification |
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
