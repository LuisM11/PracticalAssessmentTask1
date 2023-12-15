package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage{

    @FindBy(xpath = "//main//span[@data-testid='entityTitle']")
    private WebElement profileTitle;
    protected ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileTitle() {
        waitElementToBeVisible(profileTitle);
        return profileTitle.getText();
    }


    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
