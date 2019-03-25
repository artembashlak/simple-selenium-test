package ua.com.rozetka.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Class that init WebDriver instance.
 */

public class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @BeforeClass
    public void setUp() {
        DRIVER.set(new ChromeDriver());
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
