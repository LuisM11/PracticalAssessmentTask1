package page;

import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{

    public static final String BASE_URL = "";
    protected LoginPage(WebDriver driver) {
        super(driver);

    }
    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
