import java.time.LocalDateTime;

class Abonnement {
    private String type;
    private String statut;
    private LocalDateTime expirationDate;

    public Abonnement(String type, String statut) {
        this.type = type;
        this.statut = statut;
        if(type.equalsIgnoreCase("Mensuel")) {
            this.expirationDate = LocalDateTime.now().plusMonths(1);
        } else if(type.equalsIgnoreCase("Annuel")) {
            this.expirationDate = LocalDateTime.now().plusYears(1);
        } else {
            this.expirationDate = LocalDateTime.now();
        }
        
    }

    public void estValide() {
        System.out.println("[Abonnement] Statut : " + statut + " (Type: " + type + ")");
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}