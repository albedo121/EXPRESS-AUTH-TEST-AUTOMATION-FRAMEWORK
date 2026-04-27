package utils;

import io.github.cdimascio.dotenv.Dotenv;

//This package reads the email and password credentials stored in secrets.env file (local) or github secrets
public class ConfigManager {
    // Dotenv is loaded once when the class is first used
    // static = shared across all tests, no need to reload every time
    private static final Dotenv dotenv = Dotenv.configure()

            // tell dotenv which file to look for
            .filename("secrets.env")

            // if secrets.env doesn't exist (e.g. GitHub Actions), don't crash
            // just return null and let System.getenv() handle it
            .ignoreIfMissing()

            // read the file and load all key=value pairs into memory
            .load();

    public static String get(String key) {

        // first try to find the key in secrets.env (local machine)
        // e.g. dotenv.get("VALID_EMAIL_1") → "user1@example.com"
        String value = dotenv.get(key);

        // if dotenv returned null, secrets.env doesn't have it
        // this happens on GitHub Actions where there is no secrets.env file
        // so fall back to OS environment variables injected by GitHub Actions
        if (value == null) {
            value = System.getenv(key);
        }

        // return whatever was found — same result regardless of environment
        return value;
    }
}
