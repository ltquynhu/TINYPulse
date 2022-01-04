package setting;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

public class Setting_01_AddPeople extends BaseTest {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    SignUpPageObject signUp;
    LoginPageObject login;
    DashboardPageObject dashboard;
    AddPeoplePageObject addPeople;
    GlobalConstants globalConstants = new GlobalConstants();

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDrivers(browserName, appUrl);
        signUp = PageGeneratorManager.getSignUpPage(driver);
        login = signUp.clickToLoginLink();
    }

    @BeforeMethod
    public void beforeMethod() {
        login.inputEmail(globalConstants.user);
        login.clickToContinueButton();
        login.inputPassword(globalConstants.pass);
        dashboard = login.clickToSigninButton();
        addPeople = dashboard.clickToAddPeople();
    }

    @Test
    public void AddPeople_01_Successful() {
        addPeople.inputToTableData("firstName", "");
        addPeople.inputToTableData("lastName", "");
        String emailRandom = addPeople.randomInterger() + "@gmail.com";
        addPeople.inputToTableData("email", emailRandom);
        addPeople.selectDateToTableData("startDate", "Start Date");
        addPeople.selectItemDropdownToTableData("Manager", globalConstants.user);
        addPeople.clickToAddPeople();
    }

    @Test
    public void AddPeople_02_AddMore() {
        addPeople.addMore();
    }

    @AfterMethod
    public void afterMethod() {
        BasePage.logout(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
