package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;
import utilities.WaitForUtils;

public class LoginPage extends PageObject {
    private final WaitForUtils waitForUtils = new WaitForUtils();
    private final String URL_LOGIN_PAGE = BaseTest.getBaseUrl() + "/auth/login";
    private final By SELECTOR_INPUT_USERNAME = By.cssSelector("input[name='username']");
    private final By SELECTOR_INPUT_PASSWORD = By.cssSelector("input[name='password']");
    private final By SELECTOR_BUTTON_LOGIN = By.className("orangehrm-login-button");
    private final By SELECTOR_ERROR_MESSAGE = By.className("oxd-alert-content-text");

    public String getUrl(){
        return URL_LOGIN_PAGE;
    }

    public void openUrl() {
        openUrl(URL_LOGIN_PAGE);
        waitFor(ExpectedConditions.urlToBe(URL_LOGIN_PAGE));
    }

    public void inputUsername(String username){
        waitForUtils.waitUntilPresenceAndVisibilityElementLocated(SELECTOR_INPUT_USERNAME);
        typeInto(find(SELECTOR_INPUT_USERNAME), username);
    }

    public void inputPassword(String password){
        waitForUtils.waitUntilPresenceAndVisibilityElementLocated(SELECTOR_INPUT_PASSWORD);
        typeInto(find(SELECTOR_INPUT_PASSWORD), password);
    }

    public void clickButtonLogin(){
        waitForUtils.waitUntilPresenceAndVisibilityAndClickableElementLocated(SELECTOR_BUTTON_LOGIN);
        clickOn(find(SELECTOR_BUTTON_LOGIN));
    }

    public String getTextErrorMessage(){
        waitForUtils.waitUntilPresenceAndVisibilityElementLocated(SELECTOR_ERROR_MESSAGE);

        return find(SELECTOR_ERROR_MESSAGE).getText();
    }

    public String getMessageErrorFromInputPassword(){
        WebElementFacade elementPassword = find(SELECTOR_INPUT_PASSWORD);
        // get two parent element from element password
        WebElementFacade elementParentPassword = elementPassword.find(By.xpath("./../.."));

        return elementParentPassword.find(By.className("oxd-input-field-error-message")).getText();
    }

    public String getMessageErrorFromInputUsername(){
        WebElementFacade elementPassword = find(SELECTOR_INPUT_USERNAME);
        // get two parent element from element username
        WebElementFacade elementParentPassword = elementPassword.find(By.xpath("./../.."));

        return elementParentPassword.find(By.className("oxd-input-field-error-message")).getText();
    }
}
