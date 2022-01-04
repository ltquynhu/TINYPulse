package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePageUI;

import java.util.List;
import java.util.Random;

public abstract class BasePage {
    public static WebElement find(WebDriver driver, String xpath) {
        return driver.findElement(getByXpath(xpath));
    }

    public List<WebElement> finds(WebDriver driver, String xpath) {
        return driver.findElements(getByXpath(xpath));
    }

    public static By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public static void clickElement(WebDriver driver, String locator) {
        find(driver, locator).click();
    }

    public void clickElement(WebDriver driver, String locator, String... values) {
        element = find(driver, getDynamicLocator(locator, values));
        element.click();
    }

    public void sendKeysElement(WebDriver driver, String locator, String text) {
        element = find(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysElement(WebDriver driver, String locator, String... values) {
        element = find(driver, getDynamicLocator(locator, values));
        element.clear();
        element.sendKeys(values);
    }


    public String getTextElement(WebDriver driver, String xpath) {
        return find(driver, xpath).getText();
    }


    public int getElementSize(WebDriver driver, String xpath) {
        elements = finds(driver, xpath);
        return elements.size();
    }

    public int getElementSize(WebDriver driver, String xpath, String... values) {
        elements = finds(driver, getDynamicLocator(xpath, values));
        return elements.size();
    }


    public boolean isControlDisplayed(WebDriver driver, String xpath) {
        return find(driver, xpath).isDisplayed();
    }


    public void waitForElementVisible(WebDriver driver, String xpath) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpath)));
    }

    public void waitForElementVisible(WebDriver driver, String xpath, String... values) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpath, values))));
    }

    protected String getDynamicLocator(String xpath, String... values) {
        xpath = String.format(xpath, (Object[]) values);
        return xpath;
    }

    public void waitForClickable(WebDriver driver, String xpath) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpath)));
    }

    public int randomInterger() {
        Random rd = new Random();
        int i = rd.nextInt(9999);
        return i;
    }

    public static void logout(WebDriver driver) {
        clickElement(driver, BasePageUI.USER_AVATAR);
        clickElement(driver, BasePageUI.USER_LOGOUT);

    }

    private WebElement element;
    private List<WebElement> elements;
    private WebDriverWait explicitWait;
    private long longTimeout = 20;

}