package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import utilities.BaseTest;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        loginPage.openUrl();
    }

    @When("User type valid username")
    public void userTypeValidUsername() {
        loginPage.inputUsername(BaseTest.getValidUsername());
    }

    @And("User type valid password")
    public void userTypeValidPassword() {
        loginPage.inputPassword(BaseTest.getValidPassword());
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        loginPage.clickButtonLogin();
    }

    @Then("User successfully login and can see dashboard menu")
    public void userSuccessfullyLoginAndCanSeeDashboardMenu() {
        String message = "Main Menu Item should be displayed, but found not displayed.";

        Assert.assertTrue(message, dashboardPage.isMainMenuItemDisplayed());
    }

    @When("User type invalid username")
    public void userTypeInvalidUsername() {
        loginPage.inputUsername("invalid");
    }

    @And("User type invalid password")
    public void userTypeInvalidPassword() {
        loginPage.inputPassword("invalid");
    }

    @Then("User can see error message {string}")
    public void userCanSeeErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getTextErrorMessage();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("User can see error message {string} on field password")
    public void userCanSeeErrorMessageOnFieldPassword(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getMessageErrorFromInputPassword();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("User can see error message {string} on field username")
    public void userCanSeeErrorMessageOnFieldUsername(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getMessageErrorFromInputUsername();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
