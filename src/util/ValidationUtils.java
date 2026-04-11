package src.util;
import java.util.regex.Pattern;

//final is used and this class cannot be inherited
public final class ValidationUtils {
    //email pattern
    private static final Pattern EMAIL_PATTERN=
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    //username pattern
    private static final Pattern USERNAME_PATTERN=
        Pattern.compile("^[A-Za-z0-9_]{3,30}$");

    //here all methods are static and doenot need to create an instance thus private constructor
    private ValidationUtils() {
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidUsername(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }
    
        public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isInLatRange(double lat) {
        return lat >= -90 && lat <= 90;
    }

    public static boolean isInLonRange(double lon) {
        return lon >= -180 && lon <= 180;
    }

    public static void requireNonBlank(String value, String fieldName) {
        if (isBlank(value))
            throw new IllegalArgumentException(fieldName + " must not be blank.");
    }

    //ensure if null and return trimmed
    public static String safe(String s) {
        return s == null ? "" : s.trim();
    }

}
