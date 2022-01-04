package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;

public class DashboardPageObject extends BasePage {

    private WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddPeoplePageObject clickToAddPeople() {
        waitForClickable(driver, BasePageUI.MENU_SETTINGS);
        clickElement(driver, BasePageUI.MENU_SETTINGS);
        waitForClickable(driver, BasePageUI.MENU_SETTINGS_ADDPEOPLE);
        clickElement(driver, BasePageUI.MENU_SETTINGS_ADDPEOPLE);
        return PageGeneratorManager.getAddPeoplePage(driver);
    }


}
