
abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected int numTelephone;
    protected String role;
    protected String passwordHash;

    public Utilisateur(int id, String nom, String email, int numTelephone, String password, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.passwordHash = hashPassword(password);
        this.numTelephone = numTelephone;
        this.role = role;
    }


    public boolean passwordMatches(String password) {
        return hashPassword(password).equals(passwordHash);

    }

    public void seConnecter() {
        System.out.println("[Auth] " + nom + " est connecté avec succès.");
    }

    public String getRole() {
        return this.role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    private String hashPassword(String password) {
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm introuvable", e);
        }

    }
}