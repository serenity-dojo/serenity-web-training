package serenityswag.xpathdemo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLocatingElementsWithXPath {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions loginActions;

    @Steps
    InventoryActions inventoryActions;

    @Before
    public void openInventory() {
        loginActions.as(User.STANDARD_USER);

    }

    @Test
    public void addItemsToTheCart() {
        inventoryActions.viewInventory();

        inventoryActions.addItemsToCart("Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Onesie");

        assertThat(inventoryActions.shoppingCartTally()).isEqualTo(3);

        inventoryActions.removeFromCart("Sauce Labs Fleece Jacket");

        assertThat(inventoryActions.shoppingCartTally()).isEqualTo(2);

    }
}
