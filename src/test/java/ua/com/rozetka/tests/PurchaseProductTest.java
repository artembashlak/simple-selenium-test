package ua.com.rozetka.tests;

import org.testng.annotations.Test;
import ua.com.rozetka.core.BaseTest;
import ua.com.rozetka.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertThat(url).contains("rozetka");
        assertThat(title).isNotNull();
        assertThat(productSumInCart).isEqualTo("13 900");
    }
}
