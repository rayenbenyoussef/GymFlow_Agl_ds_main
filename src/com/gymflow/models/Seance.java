class Seance {
    private String type;
    private String heure;
    private int capacite;
    private int inscrits;

    public Seance(String type, String heure, int capacite) {
        this.type = type;
        this.heure = heure;
        this.capacite = capacite;
        this.inscrits = 0;
    }

    public String getType() { return type; }
    public String getHeure() { return heure; }
    public int getPlacesRestantes() { return capacite - inscrits; }

    public boolean reserver() {
        if (inscrits < capacite) {
            inscrits++;
            return true;
        }
        return false;
    }

    public void annuler() {
        if (inscrits > 0) inscrits--;
    }

    @Override
    public String toString() {
        return "[" + type + "] à " + heure + " (Places: " + getPlacesRestantes() + "/" + capacite + ")";
    }
}