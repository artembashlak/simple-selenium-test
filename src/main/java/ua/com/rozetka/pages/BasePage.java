package ua.com.rozetka.pages;

import org.openqa.selenium.support.PageFactory;

import static org.joor.Reflect.on;
import static ua.com.rozetka.core.BaseTest.getDriver;

/**
 * Class with default url, page factory with page and driver and reflect open method that
 * return page object.
 */

public class BasePage {
    protected String baseURL = "https://rozetka.com.ua";

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static <T extends BasePage> T open(final Class<T> pageClass) {
        PageFactory.initElements(getDriver(), pageClass);
        return on(pageClass).create().get();
    }
}
