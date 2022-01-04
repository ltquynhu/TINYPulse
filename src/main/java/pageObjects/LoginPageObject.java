package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void inputEmail(String emailValue) {
        waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
        sendKeysElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);
    }

    public void inputPassword(String passwordValue) {
        waitForElementVisible(driver,LoginPageUI.PASS_TEXTBOX);
        sendKeysElement(driver, LoginPageUI.PASS_TEXTBOX, passwordValue);
    }

    public void clickToContinueButton() {
        waitForClickable(driver,LoginPageUI.CONTINUE_BUTTON);
        clickElement(driver, LoginPageUI.CONTINUE_BUTTON);
    }

    public DashboardPageObject clickToSigninButton() {
        waitForClickable(driver,LoginPageUI.SIGNIN_BUTTON);
        clickElement(driver, LoginPageUI.SIGNIN_BUTTON);
        return PageGeneratorManager.getDashboardPage(driver);

    }
}
