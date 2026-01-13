package utils;

import config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = TestConfig.browser();
        boolean headless = TestConfig.headless();

        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if (headless) options.addArguments("-headless");
                return new FirefoxDriver(options);
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1440,900");
                if (headless) options.addArguments("--headless=new");
                return new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser + ". Use chrome or firefox.");
        }
    }
}
