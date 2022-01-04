package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.SignUpUI;

public class SignUpPageObject extends BasePage {

    private WebDriver driver;
    public SignUpPageObject(WebDriver driver){
        this.driver =driver;
    }

    public LoginPageObject clickToLoginLink() {
        waitForClickable(driver,SignUpUI.LOGIN_LINK);
        clickElement(driver, SignUpUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }
}
