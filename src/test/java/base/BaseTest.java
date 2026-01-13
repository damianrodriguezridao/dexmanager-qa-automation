package base;

import config.TestConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().deleteAllCookies();
        driver.get(TestConfig.baseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (driver != null && !result.isSuccess()) {
                takeScreenshot(result.getName());
            }
        } catch (Exception ignored) {
        } finally {
            if (driver != null) driver.quit();
        }
    }

    private void takeScreenshot(String testName) throws Exception {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path outDir = Path.of("target", "screenshots");
        Files.createDirectories(outDir);
        Path outFile = outDir.resolve(testName + "_" + timestamp + ".png");
        Files.write(outFile, bytes);
        System.out.println("Screenshot saved at: " + outFile.toAbsolutePath());
    }
}
