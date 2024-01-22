package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import utilities.WaitForUtils;

public class DashboardPage extends PageObject {
    private final WaitForUtils waitForUtils = new WaitForUtils();
    private final By SELECTOR_MAIN_MENU_ITEM = By.className("oxd-main-menu");
    private final By SELECTOR_USER_DROPDOWN = By.className("oxd-userdropdown-tab");
    private final By SELECTOR_USER_DROPDOWN_LOGOUT = By.xpath("//a[contains(text(),'Logout')]");

    public Boolean isMainMenuItemDisplayed() {
        waitForUtils.waitUntilPresenceAndVisibilityElementLocated(SELECTOR_MAIN_MENU_ITEM);

        return find(SELECTOR_MAIN_MENU_ITEM).isDisplayed();
    }

    public void clickUserDropdown(){
        waitForUtils.waitUntilPresenceAndVisibilityAndClickableElementLocated(SELECTOR_USER_DROPDOWN);
        clickOn(find(SELECTOR_USER_DROPDOWN));
    }

    public void clickButtonLogout(){
        waitForUtils.waitUntilPresenceAndVisibilityAndClickableElementLocated(SELECTOR_USER_DROPDOWN_LOGOUT);
        clickOn(find(SELECTOR_USER_DROPDOWN_LOGOUT));
    }
}
