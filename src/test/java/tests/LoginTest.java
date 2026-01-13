package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Login to Dex Manager with the challenge credentials and validate successful authentication.")
    public void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage home = loginPage.loginWithDefaultCredentials();

        Assert.assertTrue(home.isLoggedIn(),
                "Expected to be logged in, but post-login indicators were not found (Content menu/sidebar).");
    }
}
