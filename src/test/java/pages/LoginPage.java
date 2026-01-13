package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Fallback selectors to handle small UI changes in the demo environment
    private final By usernameInput = By.cssSelector("input[name='username'], input#username, input[type='text']");
    private final By passwordInput = By.cssSelector("input[name='password'], input#password, input[type='password']");
    private final By loginButton   = By.cssSelector("button[type='submit'], button, button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        WebElement el = waits.visible(usernameInput);
        el.clear();
        el.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement el = waits.visible(passwordInput);
        el.clear();
        el.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        waits.clickable(loginButton).click();
        return new HomePage(driver);
    }

    public HomePage loginWithDefaultCredentials() {
        return this
                .typeUsername(TestConfig.username())
                .typePassword(TestConfig.password())
                .submitLogin();
    }
}
