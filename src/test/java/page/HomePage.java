package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage{

    private static final Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header[@data-testid='topbar']//button[@data-testid='login-button']")
    private WebElement loginButton;


    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }


    @Override
    public HomePage openPage() {
        logger.info("Opening home page");
        driver.get(BASE_URL);
        return this;
    }
}
