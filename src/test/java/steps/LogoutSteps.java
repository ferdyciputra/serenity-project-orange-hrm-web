package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;

public class LogoutSteps extends PageObject {

    @Steps
    DashboardPage dashboardPage;

    @Steps
    LoginPage loginPage;

    @When("User clicks on the user dropdown")
    public void userClicksOnTheUserDropdown() {
        dashboardPage.clickUserDropdown();
    }

    @And("User clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        dashboardPage.clickButtonLogout();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = loginPage.getUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
