package ua.com.rozetka.tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import ua.com.rozetka.core.BaseTest;
import ua.com.rozetka.pages.HomePage;

import static ua.com.rozetka.pages.BasePage.open;

public class PurchaseProductTest extends BaseTest {

    @Test
    public void shouldAddItemToCart() {
        String productSumInCart = open(HomePage.class)
                .openURL()
                .clickSearchInput()
                .typeProductName("iphone")
                .clickElementInDropdown()
                .selectRoseProduct()
                .selectGreyColor()
                .addProductToCart()
                .getSumInPopout();

        String title = getDriver().getTitle();
        String url = getDriver().getCurrentUrl();


        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(productSumInCart).isEqualTo("13 900");
        soft.assertThat(url).contains("rozetka");
        soft.assertThat(title).isNotNull();
        soft.assertAll();

    }
}
