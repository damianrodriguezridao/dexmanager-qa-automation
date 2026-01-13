package config;

public class TestConfig {
    public static String baseUrl() {
        return System.getProperty("baseUrl", "https://demo4.dexmanager.com/");
    }

    public static String username() {
        return System.getProperty("username", "challengeqa");
    }

    public static String password() {
        return System.getProperty("password", "Abcd1234");
    }

    public static String browser() {
        return System.getProperty("browser", "chrome").toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }
}
