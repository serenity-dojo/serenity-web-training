package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.authentication.actions.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenViewingHighlightedProducts {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject productList;

    ProductDetailsPageObject productDetails;

    @Test
    void shouldDisplayHighlightedProductsOnTheWelcomePage() {
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay)
                .hasSize(6)
                .contains("Sauce Labs Backpack");
    }

    @Test
    void highlightedProductsShouldDisplayTheCorrespondingImages() {
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }

    @Test
    void shouldDisplayCorrectProductDetailsPage() {
        login.as(User.STANDARD_USER);
         String firstItemName = productList.titles().get(0);
         productList.openProductDetailsFor(firstItemName);

         assertThat(productDetails.productName()).isEqualTo(firstItemName);
         productDetails.productImageWithAltValueOf(firstItemName).isVisible();
    }
}
