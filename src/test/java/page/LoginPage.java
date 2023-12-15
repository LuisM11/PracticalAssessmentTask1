package page;

import model.LoginCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    public static final String BASE_URL = "";
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "login-username")
    private WebElement usernameField;

    @FindBy(id = "username-error")
    private WebElement usernameError;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "password-error")
    private WebElement passwordError;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@data-encore-id='banner']//span")
    private WebElement bannerError;


    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getBannerError() {
        waitElementToBeVisible(bannerError);
        return bannerError.getText();
    }

    public String getTextFieldError(String field) {
        switch (field) {
            case "username":
                waitElementToBeVisible(usernameError);
                return usernameError.getText();
            case "password":
                waitElementToBeVisible(passwordError);
                return passwordError.getText();
            default:
                logger.error("No such field");
                throw new IllegalArgumentException("No such field");
        }
    }
    public LoginPage clearInputFields() {
        logger.info("Clearing input fields");
        deleteUntilEmpty(usernameField);
        deleteUntilEmpty(passwordField);
        return this;
    }

    private void deleteUntilEmpty(WebElement element) {
        waitElementToBeClickable(element);
        scrollToElement(element);
        logger.info("Clearing input field " + element);
        while (!element.getAttribute("value").isEmpty()) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
    public HomePage submitLoginForm() {
        click(loginButton);
        return new HomePage(driver);
    }

    public LoginPage enterLogin(LoginCredentials credentials) {
        waitElementToBeVisible(usernameField);
        logger.info("Entering login credentials");
        click(usernameField);
        usernameField.sendKeys(credentials.getUsername());
        click(passwordField);
        passwordField.sendKeys(credentials.getPassword());
        return this;
    }
    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
