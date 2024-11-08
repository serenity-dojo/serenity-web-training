package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenViewingHighlightedProducts {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsActions viewProductDetails;

    ProductList productList;

    ProductDetails productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage() {
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6)
                                     .contains("Sauce Labs Backpack");
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages() {
        login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {
        login.as(User.STANDARD_USER);

        String firstItemName = productList.titles().get(0);

        viewProductDetails.forProductWithName(firstItemName);

        Serenity.reportThat("The product name should be correctly displayed",
                () -> assertThat(productDetails.productName()).isEqualTo(firstItemName)
        );
        Serenity.reportThat("The product image should have the correct alt text",
                () -> productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible()
        );
    }
}
