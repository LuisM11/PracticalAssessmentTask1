package test;


import config.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class CommonTestsConditions {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.createDriver();
    }

    @AfterEach
    public void stopBrowser() {
        WebDriverSingleton.closeDriver();
    }

}
