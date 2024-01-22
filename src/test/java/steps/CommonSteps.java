package steps;

import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import pageobjects.LoginPage;
import utilities.BaseTest;

public class CommonSteps extends PageObject {

    @Steps
    LoginPage loginPage;

    @Given("User already in Dashboard Page")
    public void userAlreadyInDashboardPage() {
        loginPage.openUrl();
        loginPage.inputUsername(BaseTest.getValidUsername());
        loginPage.inputPassword(BaseTest.getValidPassword());
        loginPage.clickButtonLogin();
    }
}
