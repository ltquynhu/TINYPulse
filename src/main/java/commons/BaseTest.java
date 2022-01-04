package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    WebDriver driver;

    protected WebDriver getBrowserDrivers(String browserName, String appUrl) {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                //Set No Proxy for FF
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("network.proxy.type", 0);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
//                System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case CHEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(options);
                break;
            default:
                System.out.println("We don't support that kind of browser.");
        }
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}