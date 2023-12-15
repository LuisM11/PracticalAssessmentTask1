package test;

import model.LoginCredentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.AbstractPage;
import page.HomePage;
import page.LoginPage;

import java.util.stream.Stream;

public class LoginPageTest extends CommonTestsConditions {

    public static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                Arguments.of(new LoginCredentials("juanito2j@gmail.com", "juanitoAlimana")),
                Arguments.of(new LoginCredentials("pepitodbz@hotmail.com", "pepitoForever")),
                Arguments.of(new LoginCredentials("arsenal2024winners@yopmail.com", "arsenal2024winners123"))
        );
    }


    @Test
    public void LoginWithEmptyCredentials() {
        String usernameExpectedError = "Please enter your Spotify username or email address.";
        String passwordExpectedError = "Please enter your password.";
        HomePage homePage = new HomePage(driver);
        LoginCredentials credentials = new LoginCredentials("hola@yopmail.com", "helouMonika");

        LoginPage loginPage = homePage.openPage().clickLoginButton().enterLogin(credentials).clearInputFields();
        Assertions.assertEquals(usernameExpectedError, loginPage.getTextFieldError("username"));
        Assertions.assertEquals(passwordExpectedError, loginPage.getTextFieldError("password"));
    }

    @ParameterizedTest
    @MethodSource("incorrectCredentials")
    public void LoginWithIncorrectCredentials(LoginCredentials credentials) {
        String expectedError = "Incorrect username or password.";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openPage().clickLoginButton().enterLogin(credentials).submitLoginForm();
        Assertions.assertEquals(expectedError, loginPage.getBannerError());
    }


}
