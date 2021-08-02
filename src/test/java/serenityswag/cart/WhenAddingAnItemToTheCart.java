package serenityswag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.CartActions;
import serenityswag.cart.ShoppingCartIcon;
import serenityswag.inventory.ProductList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public void login() {
        login.as(STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartBadge;

    @Steps
    CartActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        // Check that the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
                () -> assertThat(shoppingCartBadge.badgeCount()).isEmpty()
        );

        // Add 1 item to the cart
        cart.addItem("Sauce Labs Backpack");

        // The shopping cart badge should be "1"
        Serenity.reportThat("The shopping cart badge should now be '1'",
                () -> assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1")
        );
    }

    ProductList productList;

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        // Add several items to the cart
        List<String> selectedItems = firstThreeProductTitlesDisplayed();

        // Open the cart page
        cart.addItems(selectedItems);

        String cartBadgeCount = Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart badge should now be " + cartBadgeCount,
                () -> assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount)
        );

        cart.openCart();

        Serenity.reportThat("Should see all of the items listed",
                () -> assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );
    }

    CartPageObject cartPage;

    @Test
    public void pricesForEachItemShouldBeShownInTheCart() {

        // add items to the shopping cart
        cart.addItems(firstThreeProductTitlesDisplayed());

        // Open the cart page
        cartPage.open();

        // Check that each item in the cart has a price
        List<CartItem> items = cartPage.items();

        assertThat(items).hasSize(3)
                .allMatch(item -> item.price() > 0.0);
    }

    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0, 3);
    }
}
