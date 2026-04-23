abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected int numTelephone;
    protected String passwordHash;

    public Utilisateur(int id, String nom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.passwordHash = hashPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public boolean passwordMatches(String password) {
        return hashPassword(password).equals(passwordHash);
    }

    public void seConnecter() {
        System.out.println("[Auth] " + nom + " est connecté avec succès.");
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