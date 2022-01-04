package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static SignUpPageObject getSignUpPage(WebDriver driver) {
        return new SignUpPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPage(WebDriver driver) {
        return new DashboardPageObject(driver);
    }

    public static AddPeoplePageObject getAddPeoplePage(WebDriver driver) {
        return new AddPeoplePageObject(driver);
    }
}
