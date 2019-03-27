package ua.com.rozetka.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Class that init WebDriver instance.
 */

public class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public void setUp() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        DRIVER.set(new ChromeDriver(chromeOptions));
        DRIVER.get().manage().timeouts().implicitlyWait(20, SECONDS);
    }

    @AfterClass
    public void tearDown() {
        DRIVER.get().quit();
        DRIVER.remove();
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getDriver(), 10);
    }

}
