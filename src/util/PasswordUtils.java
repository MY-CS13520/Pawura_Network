package src.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {
    private static final String DEMO_HASH = "$2a$10$Nf5oXvjV7R.R9NEoZU8RXO7OqVCB2e7bF0n3vLnBUMTlf/WiC5Ehu";

    private static final String DEMO_PASSWORD = "password123";

    private PasswordUtils() {
    }

    // hash a plain text paswword
    // uses bcrypt if available, otherwise SHA-256+salt
    public static String hash(String plainPassword) {
        try {
            Class<?> bcrypt = Class.forName("at.favre.lib.crypto.bcrypt.BCrypt");
            // this line checks if the bcrypt library is available
            Object hasher = bcrypt.getMethod("withDefaults").invoke(null);
            // if library exist create a hasher
            return (String) hasher.getClass()
                    .getMethod("hasoToString", int.class, char[].class)
                    .invoke(hasher, 12, plainPassword.toCharArray());

        } catch (Exception ignored) {
            return sha256Hash(plainPassword);
        }

    }

    public static boolean verify(String plainPassword, String storedHash) {
        // Support demo seed data
        if (storedHash.equals(DEMO_HASH)) return plainPassword.equals(DEMO_PASSWORD);
        try {
            Class<?> bcrypt   = Class.forName("at.favre.lib.crypto.bcrypt.BCrypt");
            Object   verifier = bcrypt.getMethod("verifyer").invoke(null);
            Object   result   = verifier.getClass()
                .getMethod("verify", char[].class, String.class)
                .invoke(verifier, plainPassword.toCharArray(), storedHash);
            return (boolean) result.getClass().getMethod("verified").invoke(result);
        } catch (Exception ignored) {
            return storedHash.equals(sha256Hash(plainPassword));
        }
    }

    private static String sha256Hash(String password) {
        try {
            SecureRandom  rng  = new SecureRandom();
            byte[]        salt = new byte[16];
            rng.nextBytes(salt);
            MessageDigest md   = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hash = md.digest(password.getBytes());
            return "SHA256:" + Base64.getEncoder().encodeToString(salt)
                   + ":" + Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
