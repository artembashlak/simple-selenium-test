package ua.com.rozetka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static ua.com.rozetka.core.BaseTest.getDriver;

/**
 * Class with homepage elements, basic methods to work with homepage elements.
 */

public class HomePage extends BasePage {
    @FindBy(how = How.NAME, using = "search")
    private WebElement searchProductInput;
    @FindBy(how = How.XPATH, using = "//b[contains(text(),'se')]")
    private WebElement itemInSearchResultsList;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Apple iPhone SE 64gb Rose Gold Neverlock')]")
    private WebElement roseIphoneProduct;
    @FindBy(how = How.XPATH, using = "//button[@name='topurchases']")
    private WebElement purchaseButton;
    @FindBy(how = How.XPATH, using = "//li[@class='pp-variants-l-i pp-variants-l-i-last']//a[@name='variant']")
    private WebElement greyColorInPicker;
    @FindBy(how = How.XPATH, using = "//span[@name='sum']")
    private WebElement cartPopoutSum;

    @Step
    public HomePage openURL() {
        getDriver().get(baseURL);
        return this;
    }

    @Step
    public HomePage clickSearchInput() {
        searchProductInput.click();
        return this;
    }

    @Step
    public HomePage typeProductName(final String product) {
        searchProductInput.sendKeys(product);
        return this;
    }

    @Step
    public HomePage clickElementInDropdown() {
        itemInSearchResultsList.click();
        return this;
    }

    @Step
    public HomePage selectRoseProduct() {
        roseIphoneProduct.click();
        return this;
    }

    @Step
    public HomePage addProductToCart() {
        purchaseButton.click();
        return this;
    }

    @Step
    public HomePage selectGreyColor() {
        greyColorInPicker.click();
        return this;
    }

    @Step
    public String getSumInPopout() {
        return cartPopoutSum.getText();
    }
}
