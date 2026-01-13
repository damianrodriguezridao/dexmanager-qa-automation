package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Post-login indicators (fallback). Adjust if needed after first run.
    private final By contentMenu = By.xpath("//*[normalize-space()='Content' or contains(normalize-space(), 'Content')]");
    private final By sidebar = By.cssSelector("nav, aside, .sidebar, .menu");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        try {
            waits.visible(contentMenu);
            return true;
        } catch (Exception e) {
            try {
                waits.visible(sidebar);
                return true;
            } catch (Exception ignored) {
                return false;
            }
        }
    }
}
